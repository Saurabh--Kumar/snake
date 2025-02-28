package org.saurabh.snake.food;

import lombok.Data;
import org.saurabh.snake.entity.Coordinate;

import static org.saurabh.snake.constants.Constants.SUPER_FOOD_INCREMENTAL_LENGTH;
import static org.saurabh.snake.constants.Constants.SUPER_FOOD_POINTS;
import static org.saurabh.snake.constants.Symbols.SUPER_FOOD_SYMBOL;

@Data
public class SuperFood implements Food{

    private int foodPoints = SUPER_FOOD_POINTS;
    private String FoodSymbol = SUPER_FOOD_SYMBOL;
    private FoodType foodType = FoodType.Super;
    private int incrementalLength = SUPER_FOOD_INCREMENTAL_LENGTH;
    private final Coordinate foodCoordinate;

    public SuperFood(Coordinate foodCoordinate){
        this.foodCoordinate = foodCoordinate;
    }
    @Override
    public int getFoodPoints() {
        return 50;
    }

    @Override
    public String getFoodSymbol() {
        return "0";
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.Super;
    }

    @Override
    public int getIncrementalLength() {
        return 0;
    }

    @Override
    public Coordinate getFoodCoordinate() {
        return foodCoordinate;
    }
}
