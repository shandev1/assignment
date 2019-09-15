package com.assignment.exceptions;

class InvalidUsernameOrPasswordResponse {
    private String error;

    public InvalidUsernameOrPasswordResponse() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

/**
 * @author shan
 * <p>
 * Invalid username or password exceptions are handled in this class
 */
public class InvalidUsernameOrPasswordException extends RuntimeException {
    private InvalidUsernameOrPasswordResponse invalidUsernameOrPasswordResponse =
            new InvalidUsernameOrPasswordResponse();

    public InvalidUsernameOrPasswordException(String message) {
        invalidUsernameOrPasswordResponse.setError(message);
    }

    public InvalidUsernameOrPasswordResponse getResponse() {
        return invalidUsernameOrPasswordResponse;
    }
}
