package org.saurabh.snake.food;

import org.saurabh.snake.entity.Coordinate;

public interface Food {
    public int getFoodPoints();
    public String getFoodSymbol();

    public FoodType getFoodType();

    public int getIncrementalLength();

    public Coordinate getFoodCoordinate();
}
