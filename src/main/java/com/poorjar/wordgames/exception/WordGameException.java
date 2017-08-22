package com.poorjar.wordgames.exception;

/**
 * Created by swaroop on 8/20/17.
 */
public class WordGameException extends Exception {
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }
    public WordGameException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
    public WordGameException() {
        super();
    }
}
