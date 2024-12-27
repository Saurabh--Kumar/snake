package org.saurabh.snake.board;

import org.saurabh.snake.Coordinate;
import org.saurabh.snake.entity.Direction;

public class SimpleBoard implements Board{
    private int row;
    private int column;

    public SimpleBoard(int row, int column){
        if(row<=0 || column <= 0){
            throw new RuntimeException("Invalid board dimensions");
        }

        this.row = row;
        this.column = column;
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
