package org.example.exceptions;

public class UserNoExistException extends Exception {
    public UserNoExistException(String message) {
        super(message);
    }
}
