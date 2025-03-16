package org.saurabh.snake;

import org.saurabh.snake.entity.Direction;

import java.util.HashMap;
import java.util.Map;

public class GameLoop {

    Map<Direction, Direction> oppositeDirectionMap;

    private GamePlay gamePlay;

    private Direction currentDirection = Direction.RIGHT;

    private boolean isGameOver;

    public GameLoop(GamePlay gamePlay){
        this.gamePlay = gamePlay;
        oppositeDirectionMap = new HashMap<>();
        oppositeDirectionMap.put(Direction.DOWN, Direction.UP);
        oppositeDirectionMap.put(Direction.UP, Direction.DOWN);
        oppositeDirectionMap.put(Direction.LEFT, Direction.RIGHT);
        oppositeDirectionMap.put(Direction.RIGHT, Direction.LEFT);

    }

    public void playGame(){
        while ( ! isGameOver) {
            try{
                gamePlay.moveSnake(currentDirection);
            } catch (Exception e){
                isGameOver = true;
                throw e;
            }
        }
    }

    public void setDirection(Direction direction){
        if( ! oppositeDirectionMap.get(currentDirection).equals(direction)){
            this.currentDirection = direction;
        }
    }

    public boolean isGameOver(){
        return gamePlay.isGameOver();
    }


}
