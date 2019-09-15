package com.assignment.exceptions;

/**
 * @author shan
 * <p>
 * Invalid token exceptions are handled in this class
 */
public class InvalidTokenException extends RuntimeException {

    public static class InvalidTokenResponse {
        private String message;

        public InvalidTokenResponse() {
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    private InvalidTokenResponse invalidTokenResponse = new InvalidTokenResponse();

    public InvalidTokenException(String message) {
        invalidTokenResponse.setMessage(message);
    }

    public InvalidTokenResponse getResponse() {
        return invalidTokenResponse;
    }
}
