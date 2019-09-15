package com.assignment.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AssignmentExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({InvalidUsernameOrPasswordException.class})
    public ResponseEntity<InvalidUsernameOrPasswordResponse> handleInvalidUsernameOrPasswordException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(
                ((InvalidUsernameOrPasswordException)ex).getResponse(), new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({InvalidTokenException.class})
    public ResponseEntity<InvalidTokenResponse> handleInvalidTokenException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(
                ((InvalidTokenException)ex).getResponse(), new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<UserNotFoundResponse> handleUserNotFoundException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(
                ((UserNotFoundException)ex).getResponse(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

}
