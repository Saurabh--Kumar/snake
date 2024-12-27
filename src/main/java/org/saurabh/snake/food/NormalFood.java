package org.saurabh.snake.food;

import org.saurabh.snake.Coordinate;

public class NormalFood implements Food{
    @Override
    public int getFoodPoints() {
        return 1;
    }

    @Override
    public String getFoodSymbol() {
        return ".";
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.Normal;
    }

    @Override
    public int getIncrementalLength() {
        return 1;
    }

    @Override
    public Coordinate getFoodCoordinate() {
        return null;
    }
}
