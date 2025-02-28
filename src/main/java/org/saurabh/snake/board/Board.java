package org.saurabh.snake.board;

import org.saurabh.snake.entity.Coordinate;
import org.saurabh.snake.entity.Direction;

import java.util.List;
import java.util.Set;

public interface Board {

    Coordinate getNextCoordinate(Coordinate snakeHeadPosition, Direction direction);

    List<Coordinate> getObstacleCoordinates();

    Set<Coordinate> getFreeCoordinates();

    String getEmptyCellSymbol();
    String getObstacleSymbol();

    int getRows();
    int getColumns();

}
