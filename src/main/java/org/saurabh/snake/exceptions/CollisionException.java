package org.saurabh.snake.exceptions;

public class CollisionException extends RuntimeException{
    public CollisionException(String message){
        super(message);
    }
}
