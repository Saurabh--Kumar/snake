package org.saurabh.snake;

import org.saurabh.constants.Symbols;
import org.saurabh.snake.board.Board;
import org.saurabh.snake.entity.Snake;
import org.saurabh.snake.entity.StatsTracker;
import org.saurabh.snake.food.Food;

public class GamePlayPrinter {
    public void printBoard(GamePlay gamePlay){
        StringBuilder sb = new StringBuilder();
        Board board = gamePlay.getBoard();

        int rows = board.getRows();
        int columns = board.getColumns();

        for (int i = 0; i< 100; i++){
            sb.append(" \n");
        }

        addRowBoundary(columns, sb);

        for (int i = 0; i< rows; i++){
            sb.append(".");
            for (int j=0; j < columns; j++){
                sb.append(addCell(gamePlay, i, j));
            }
            sb.append(".\n");
        }

        addRowBoundary(columns, sb);

        System.out.print(sb.toString());
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void addRowBoundary(int columns, StringBuilder sb) {
        for (int i = 0; i< columns +2; i++){
            sb.append(Symbols.ROW_BOUNDARY);
        }
        sb.append("\n");
    }

    private String addCell(GamePlay gamePlay, int row, int column) {
        Board board = gamePlay.getBoard();
        Snake snake = gamePlay.getSnake();
        Food food = gamePlay.getFood();

        Coordinate coordinate = new Coordinate(row, column);

        if(coordinate.equals(food.getFoodCoordinate())){
            return food.getFoodSymbol();
        }

        if(snake.getSnakeBodySet().contains(coordinate)) {
            return snake.getSnakeCellSymbol();
        }

        if(board.getObstacleCoordinates().contains(coordinate)){
            return board.getObstacleSymbol();
        }

        return board.getEmptyCellSymbol();


    }

    public void printStats(StatsTracker statsTracker) {
    }
}
