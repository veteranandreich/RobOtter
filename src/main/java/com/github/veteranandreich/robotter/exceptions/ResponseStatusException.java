package com.github.veteranandreich.robotter.exceptions;

/**
 * Exception for non 200 responses
 */
public class ResponseStatusException extends Exception{
    public ResponseStatusException(String message) {
        super(message);
    }
}
