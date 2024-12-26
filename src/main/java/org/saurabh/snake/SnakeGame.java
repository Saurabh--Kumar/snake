package org.saurabh.snake;

import org.saurabh.snake.entity.Direction;

interface SnakeGame {

    void moveSnake(Direction direction);

    boolean isGameOver();

}