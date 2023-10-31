package com.workintech.exception;

public class EmailAlreadyTakenException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUD = 1L;
    public  EmailAlreadyTakenException(){

        super("The email provided is already taken");
    }
}
