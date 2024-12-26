package org.saurabh.snake;


import org.junit.Before;
import org.junit.Test;
import org.saurabh.snake.entity.Board;
import org.saurabh.snake.entity.Direction;
import org.saurabh.snake.entity.SimpleBoard;
import org.saurabh.snake.entity.Snake;

import static org.junit.jupiter.api.Assertions.*;


public class GamePlayTest {

    private GamePlay gamePlay;

    @Before
    public void init(){
        Board board = new SimpleBoard(10, 10);
        Snake snake = new Snake();
        gamePlay = GamePlay.builder()
                .snake(snake)
                .board(board)
                .movesSoFar(0)
                .isGameOver(false)
                .growthStep(5)
                .build();
    }

    @Test
    public void moveLeft(){
        gamePlay.moveSnake(Direction.LEFT);
        gamePlay.getSnake().printSnake();
        assertEquals(new Coordinate(0,9), gamePlay.getSnake().getSnakeBody().peekFirst());

    }

    @Test
    public void moveRight(){
        gamePlay.moveSnake(Direction.RIGHT);
        gamePlay.getSnake().printSnake();
        assertEquals(new Coordinate(0,1), gamePlay.getSnake().getSnakeBody().peekFirst());

    }

    @Test
    public void moveUP(){
        gamePlay.moveSnake(Direction.UP);
        gamePlay.getSnake().printSnake();
        assertEquals(new Coordinate(9,0), gamePlay.getSnake().getSnakeBody().peekFirst());

    }

    @Test
    public void moveDOWN(){
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.getSnake().printSnake();
        assertEquals(new Coordinate(1,0), gamePlay.getSnake().getSnakeBody().peekFirst());

    }

    @Test
    public void growSnake(){
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.moveSnake(Direction.RIGHT);
        gamePlay.moveSnake(Direction.DOWN);
        gamePlay.getSnake().printSnake();
        assertEquals(new Coordinate(4,1), gamePlay.getSnake().getSnakeBody().peekFirst());

    }

    @Test
    public void gameOver(){
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

        gamePlay.getSnake().printSnake();

        try {
            gamePlay.moveSnake(Direction.LEFT);
            gamePlay.getSnake().printSnake();
            fail("Game should be over");
        }catch (RuntimeException e) {
            assertEquals("Snake hit the body. Game Over", e.getMessage());
        }

        assertTrue(gamePlay.isGameOver());
    }
}