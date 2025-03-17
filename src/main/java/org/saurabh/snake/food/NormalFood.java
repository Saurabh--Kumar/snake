package org.saurabh.snake.food;

import org.saurabh.snake.entity.Coordinate;

import static org.saurabh.snake.constants.Constants.*;
import static org.saurabh.snake.constants.Symbols.NORMAL_FOOD_SYMBOL;

public class NormalFood implements Food{

    private int foodPoints = NORMAL_FOOD_POINTS;
    private String foodSymbol = NORMAL_FOOD_SYMBOL;
    private FoodType foodType = FoodType.Normal;
    private int incrementalLength = NORMAL_FOOD_INCREMENTAL_LENGTH;
    private final Coordinate foodCoordinate;

    public NormalFood(Coordinate foodCoordinate){
        this.foodCoordinate = foodCoordinate;
    }
    @Override
    public int getFoodPoints() {
        return foodPoints;
    }

    @Override
    public String getFoodSymbol() {
        return foodSymbol;
    }

    @Override
    public FoodType getFoodType() {
        return foodType;
    }

    @Override
    public int getIncrementalLength() {
        return incrementalLength;
    }

    @Override
    public Coordinate getFoodCoordinate() {
        return foodCoordinate;
    }
}
