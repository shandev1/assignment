package com.assignment.exceptions;

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

    public static class UserNotFoundResponse {
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
}
