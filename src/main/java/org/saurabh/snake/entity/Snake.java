package org.saurabh.snake.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.saurabh.snake.Coordinate;
import org.saurabh.snake.Symbols;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@Data
@Slf4j
public class Snake {
    private Deque<Coordinate> snakeBody;
    private Set<Coordinate> snakeBodySet;


    public Snake(){
        snakeBody = new LinkedList<>();
        snakeBodySet = new HashSet<>();
        Coordinate coordinate = new Coordinate(0,0);
        snakeBodySet.add(coordinate);
        snakeBody.addFirst(coordinate);
    }

    public boolean isCollision(Coordinate nextCoordinate) {
        return snakeBodySet.contains(nextCoordinate);
    }

    public void growSnakeBody(Coordinate nextCoordinate) {
        snakeBody.addFirst(nextCoordinate);
        snakeBodySet.add(nextCoordinate);
    }

    public void moveSnake(Coordinate nextCoordinate) {
        Coordinate tail = snakeBody.removeLast();
        snakeBody.addFirst(nextCoordinate);
        snakeBodySet.remove(tail);
        snakeBodySet.add(nextCoordinate);
    }

    public String getSnakeCellSymbol(){
        return Symbols.snakeBodySymbol;
    }

    public void printSnake(){
        log.info("Snake Body: {}, Set: {} ", snakeBody, snakeBodySet);

    }
}
