package org.saurabh.snake;


import org.saurabh.snake.board.Board;
import org.saurabh.snake.board.SimpleBoard;
import org.saurabh.snake.entity.Coordinate;
import org.saurabh.snake.entity.Direction;
import org.saurabh.snake.entity.Snake;
import org.saurabh.snake.exceptions.CollisionException;
import org.saurabh.snake.food.Food;
import org.saurabh.snake.food.FoodGenerator;
import org.saurabh.snake.food.NormalFood;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        GameLoop gameLoop = initializeGameLoop();

        try {
            Thread gameLoopThread = startGameLoop(gameLoop);
            captureInput(gameLoop, frame);
            gameLoopThread.join();
        } catch (Exception e){
            System.out.println("Game Over");
        } finally {
            frame.dispose();
        }

    }

    private static void captureInput(GameLoop gameLoop, JFrame frame) {
        frame.setUndecorated(true);  // Hides window borders
        frame.setSize(1, 1);  // Makes the window tiny
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> gameLoop.setDirection(Direction.UP);
                    case KeyEvent.VK_DOWN -> gameLoop.setDirection(Direction.DOWN);
                    case KeyEvent.VK_LEFT -> gameLoop.setDirection(Direction.LEFT);
                    case KeyEvent.VK_RIGHT -> gameLoop.setDirection(Direction.RIGHT);
                }
            }

            public void keyReleased(KeyEvent e) {}

            public void keyTyped(KeyEvent e) {}
        });

        frame.setVisible(true);
    }

    private static Thread startGameLoop(GameLoop gameLoop) {
        Thread gameloopThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    gameLoop.playGame();
                } catch (CollisionException e){
                    // ignore
                }
            }
        });

        gameloopThread.start();
        return gameloopThread;
    }

    private static GameLoop initializeGameLoop() {
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

        GameLoop gameLoop = new GameLoop(gamePlay);
        return gameLoop;
    }

}