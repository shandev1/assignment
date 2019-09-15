package com.assignment.exceptions;

/**
 * @author shan
 * <p>
 * Invalid username or password exceptions are handled in this class
 */
public class InvalidCredencialsException extends RuntimeException {

    public static class InvalidCredentialsResponse {
        private String error;

        public InvalidCredentialsResponse() {
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    private InvalidCredentialsResponse invalidCredentialsResponse =
            new InvalidCredentialsResponse();

    public InvalidCredencialsException(String message) {
        invalidCredentialsResponse.setError(message);
    }

    public InvalidCredentialsResponse getResponse() {
        return invalidCredentialsResponse;
    }
}
