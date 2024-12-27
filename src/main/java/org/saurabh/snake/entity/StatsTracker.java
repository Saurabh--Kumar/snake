package org.saurabh.snake.entity;

import lombok.Data;
import org.saurabh.snake.food.Food;
import org.saurabh.snake.food.FoodType;

public class StatsTracker {
    private int score;
    private int length;
    private int food;
    private int superfood;

    private StatsTracker tracker= new StatsTracker();

    public StatsTracker getStatsTracker(){
        return tracker;
    }

    private StatsTracker(){
        score = 0;
        length = 1;
        food = 0;
        superfood = 0;
    }

    public void eatFood(Food food){
        this.food+=1;
        this.length+=food.getIncrementalLength();
        this.score+=food.getFoodPoints();
        int superFoodCount = food.getFoodType() == FoodType.Super ? 1:0;
        this.superfood+=superFoodCount;
    }

}
