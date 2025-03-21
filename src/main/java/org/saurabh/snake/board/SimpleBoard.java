package org.saurabh.snake.board;

import org.saurabh.snake.entity.Coordinate;
import org.saurabh.snake.constants.Symbols;
import org.saurabh.snake.entity.Direction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimpleBoard implements Board{
    private int row;
    private int column;

    private Set<Coordinate> freeCoordinates;

    public SimpleBoard(int row, int column){
        if(row<=0 || column <= 0){
            throw new RuntimeException("Invalid board dimensions");
        }

        this.row = row;
        this.column = column;
        freeCoordinates = new HashSet<>();

        for (int i = 0; i < row; i++){
            for (int j = 0; j< column; j++){
                freeCoordinates.add(new Coordinate(i,j));
            }
        }
    }


    @Override
    public Coordinate getNextCoordinate(Coordinate snakeHeadPosition, Direction direction) {
        Coordinate nextCoordinate = new Coordinate();

        if(direction == Direction.UP){
            nextCoordinate.setRow(snakeHeadPosition.getRow()-1);
            nextCoordinate.setColumn(snakeHeadPosition.getColumn());
        } else if(direction == Direction.DOWN){
            nextCoordinate.setRow(snakeHeadPosition.getRow()+1);
            nextCoordinate.setColumn(snakeHeadPosition.getColumn());
        }else if(direction == Direction.LEFT){
            nextCoordinate.setRow(snakeHeadPosition.getRow());
            nextCoordinate.setColumn(snakeHeadPosition.getColumn()-1);
        }else if(direction == Direction.RIGHT){
            nextCoordinate.setRow(snakeHeadPosition.getRow());
            nextCoordinate.setColumn(snakeHeadPosition.getColumn()+1);
        }

        handleBoundary(nextCoordinate);


        return nextCoordinate;
    }

    @Override
    public List<Coordinate> getObstacleCoordinates() {
        return new ArrayList<>();
    }

    @Override
    public Set<Coordinate> getFreeCoordinates() {
        return freeCoordinates;
    }

    @Override
    public String getEmptyCellSymbol() {
        return Symbols.EMPTY_CELL_SYMBOL;
    }

    @Override
    public String getObstacleSymbol() {
        return Symbols.OBSTACLE_SYMBOL;
    }

    @Override
    public int getRows() {
        return row;
    }

    @Override
    public int getColumns() {
        return column;
    }

    private void handleBoundary(Coordinate nextCoordinate) {
        if(nextCoordinate.getRow() <0) {
            nextCoordinate.setRow(row-1);
        }

        if(nextCoordinate.getColumn() <0) {
            nextCoordinate.setColumn(column-1);
        }

        if(nextCoordinate.getRow() == row) {
            nextCoordinate.setRow(0);
        }

        if(nextCoordinate.getColumn()== column){
            nextCoordinate.setColumn(0);
        }
    }
}
