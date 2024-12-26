package org.saurabh.snake;

import lombok.Builder;
import lombok.Getter;
import org.saurabh.snake.entity.Board;
import org.saurabh.snake.entity.Direction;
import org.saurabh.snake.entity.Snake;

@Builder
@Getter
public class GamePlay implements SnakeGame{

    private Snake snake;
    private Board board;

    private boolean isGameOver;
    private long movesSoFar;
    private int growthStep;

    @Override
    public void moveSnake(Direction direction) {
        if(isGameOver){
            throw new RuntimeException("Game is already Over");
        }

        if(direction ==null){
            throw new RuntimeException("Invalid direction");
        }

        movesSoFar += 1;

        Coordinate snakeHeadPosition = snake.getSnakeBody().peekFirst();

        Coordinate nextCoordinate = board.getNextCoordinate(snakeHeadPosition, direction);

        if(snake.isCollision(nextCoordinate)){
            isGameOver = true;
            throw new RuntimeException("Snake hit the body. Game Over");
        }

        if(movesSoFar%growthStep == 0){
            snake.growSnakeBody(nextCoordinate);
        } else{
            snake.moveSnake(nextCoordinate);
        }
    }

    @Override
    public boolean isGameOver() {
        return isGameOver;
    }
}
