package org.saurabh.snake.entity;

import org.saurabh.snake.Coordinate;

public interface Board {

    Coordinate getNextCoordinate(Coordinate snakeHeadPosition, Direction direction);
}
