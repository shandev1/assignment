package com.assignment.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author shan
 * <p>
 * API Error response handler
 */
@ControllerAdvice
public class AssignmentExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({UsernameNotFoundException.class})
    public ResponseEntity<InvalidCredencialsException.InvalidCredentialsResponse> handleUsernameNotFoundExceptionException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(
                ((InvalidCredencialsException) ex).getResponse(), new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({InvalidCredencialsException.class})
    public ResponseEntity<InvalidCredencialsException.InvalidCredentialsResponse> handleInvalidUsernameOrPasswordException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(
                ((InvalidCredencialsException) ex).getResponse(), new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({InvalidTokenException.class})
    public ResponseEntity<InvalidTokenException.InvalidTokenResponse> handleInvalidTokenException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(
                ((InvalidTokenException) ex).getResponse(), new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<UserNotFoundException.UserNotFoundResponse> handleUserNotFoundException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(
                ((UserNotFoundException) ex).getResponse(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

}
