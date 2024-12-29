package org.saurabh.snake.board;

import org.saurabh.snake.Coordinate;
import org.saurabh.snake.entity.Direction;

import java.util.List;

public interface Board {

    Coordinate getNextCoordinate(Coordinate snakeHeadPosition, Direction direction);

    List<Coordinate> getObstacleCoordinates();

    String getEmptyCellSymbol();
    String getObstacleSymbol();

    int getRows();
    int getColumns();
}
