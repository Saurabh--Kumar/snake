package org.saurabh.snake.entity;

import lombok.Data;

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

}
