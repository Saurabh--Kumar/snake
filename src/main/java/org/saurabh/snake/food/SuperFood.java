package org.saurabh.snake.food;

import org.saurabh.snake.Coordinate;

public class SuperFood implements Food{
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
        return null;
    }
}
