package com.assignment.exceptions;

class UserNotFoundResponse {
    private String message;

    public UserNotFoundResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

/**
 * @author shan
 * <p>
 * User not found exceptions are handled in this class
 */
public class UserNotFoundException extends RuntimeException {
    private UserNotFoundResponse userNotFoundResponse = new UserNotFoundResponse();

    public UserNotFoundException(String message) {
        userNotFoundResponse.setMessage(message);
    }

    public UserNotFoundResponse getResponse() {
        return userNotFoundResponse;
    }
}
