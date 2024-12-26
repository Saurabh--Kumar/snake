package org.saurabh.snake.board;

import org.saurabh.snake.Coordinate;
import org.saurabh.snake.entity.Direction;

public interface Board {

    Coordinate getNextCoordinate(Coordinate snakeHeadPosition, Direction direction);
}
