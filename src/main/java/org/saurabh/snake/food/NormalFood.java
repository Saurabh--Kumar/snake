package org.saurabh.snake.food;

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
    public int getIncrementalLength() {
        return 1;
    }
}
