package org.saurabh.snake;


import org.saurabh.snake.GamePlay;
import org.saurabh.snake.GamePlayPrinter;
import org.saurabh.snake.board.Board;
import org.saurabh.snake.board.SimpleBoard;
import org.saurabh.snake.entity.Coordinate;
import org.saurabh.snake.entity.Direction;
import org.saurabh.snake.entity.Snake;
import org.saurabh.snake.food.Food;
import org.saurabh.snake.food.FoodGenerator;
import org.saurabh.snake.food.NormalFood;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Board board = new SimpleBoard(10, 20);
        Snake snake = new Snake();
        GamePlayPrinter gamePlayPrinter = new GamePlayPrinter();
        Food food = new NormalFood(new Coordinate(5,5));
        FoodGenerator foodGenerator = FoodGenerator.builder()
                .board(board)
                .snake(snake)
                .build();
        GamePlay gamePlay = GamePlay.builder()
                .snake(snake)
                .board(board)
                .movesSoFar(0)
                .isGameOver(false)
                .growthStep(5)
                .food(food)
                .gamePlayPrinter(gamePlayPrinter)
                .foodGenerator(foodGenerator)
                .build();


        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);

        gamePlay.moveSnake(Direction.RIGHT);
        gamePlay.moveSnake(Direction.UP);


        /*for (int i = 0; i <= 100; i++) {
            String str = "\rProgress: " + i + "%" + "\n" + "hi";
            System.out.print(str);
            Thread.sleep(100); // Sleep for 100 milliseconds to simulate work } System.out.println("\nDone!");
        }
            //method();*/

    }


        public static void method() throws InterruptedException {
            int[][] matrix = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };

            for (int i = 0; i < 10; i++) {
                clearConsole();
                printMatrix(matrix);
                Thread.sleep(1000);  // Simulate some delay

                // Update the matrix to show changes
                updateMatrix(matrix);
            }
            System.out.println("Done!");
        }

        private static void printMatrix(int[][] matrix) {
            for (int[] row : matrix) {
                for (int element : row) {
                    System.out.print(element + " ");
                }
                System.out.print("\n");
            }
        }

        private static void clearConsole() {
            try {
                if (System.getProperty("os.name").contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static void updateMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] += 1;
                }
            }
        }

}