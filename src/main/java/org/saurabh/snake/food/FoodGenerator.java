package org.saurabh.snake.food;

import lombok.Builder;
import org.saurabh.snake.board.Board;
import org.saurabh.snake.entity.Coordinate;
import org.saurabh.snake.entity.Snake;

import java.util.*;

@Builder
public class FoodGenerator {

    private Board board;
    private Snake snake;

    public Food generateFood(FoodType foodType){
        Coordinate foodCoordinate = getFoodCoordinate();
        Food food;
        if(FoodType.Super.equals(foodType)){
            food = new SuperFood(foodCoordinate);
        } else {
            food = new NormalFood(foodCoordinate);
        }
        return food;
    }

    private Coordinate getFoodCoordinate() {
        Set<Coordinate> freeCoordinates = new HashSet<>(board.getFreeCoordinates());
        Set<Coordinate> snakeBodyCoordinates = snake.getSnakeBodySet();

        freeCoordinates.removeAll(snakeBodyCoordinates);

        List<Coordinate> freeCoordinatesList = new ArrayList<>(freeCoordinates);

        Random random = new Random();
        int randomIndex = random.nextInt(freeCoordinatesList.size());
        return freeCoordinatesList.get(randomIndex);
    }

}
