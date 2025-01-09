package com.sithu.springrestfundamental.exception;

public class PlayerNotFoundException extends RuntimeException{

    public PlayerNotFoundException(){
        super();
    }

    public PlayerNotFoundException(String message){
        super(message);
    }

    public PlayerNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public PlayerNotFoundException(Throwable cause){
        super(cause);
    }
}
