package org.saurabh.snake;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.saurabh.snake.board.Board;
import org.saurabh.snake.entity.Direction;
import org.saurabh.snake.entity.Snake;
import org.saurabh.snake.entity.StatsTracker;
import org.saurabh.snake.food.Food;
import org.saurabh.snake.food.FoodGenerator;

@Builder
@Getter
@Slf4j
public class GamePlay implements SnakeGame{

    private Snake snake;
    private Board board;
    private Food food;
    private FoodGenerator foodGenerator;
    private GamePlayPrinter gamePlayPrinter;
    private StatsTracker statsTracker;

    private boolean isGameOver;
    private long movesSoFar;
    private int growthStep;


    @Override
    public void moveSnake(Direction direction) {
        try {
            if (isGameOver) {
                throw new RuntimeException("Game is already Over");
            }

            if (direction == null) {
                throw new RuntimeException("Invalid direction");
            }

            movesSoFar += 1;

            Coordinate snakeHeadPosition = snake.getSnakeBody().peekFirst();

            Coordinate nextCoordinate = board.getNextCoordinate(snakeHeadPosition, direction);

            if (snake.isCollision(nextCoordinate)) {
                isGameOver = true;
                throw new RuntimeException("Snake hit the body. Game Over");
            }

            if (movesSoFar % growthStep == 0) {
                snake.growSnakeBody(nextCoordinate);
                statsTracker.eatFood(food);
            } else {
                snake.moveSnake(nextCoordinate);
            }

            gamePlayPrinter.printBoard(this);
        } catch (Exception e){
            log.error("Game Over. Exception: {}", e);
            gamePlayPrinter.printStats(statsTracker);
        }
    }


    @Override
    public boolean isGameOver() {
        return isGameOver;
    }
}
