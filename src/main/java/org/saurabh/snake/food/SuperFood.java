package org.saurabh.snake.food;

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
    public int getIncrementalLength() {
        return 0;
    }
}
