package com.assignment.auth;

import com.assignment.exceptions.InvalidCredencialsException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shan
 * <p>
 * Un-authorized error handler
 */
@Component
public class UnauthorizedErrorHandler implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(UnauthorizedErrorHandler.class);

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException exception) throws IOException {

        logger.error("Responding with unauthorized error : []",
                exception.getMessage());

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");

        InvalidCredencialsException.InvalidCredentialsResponse invalidCredentialsResponse =
                new InvalidCredencialsException.InvalidCredentialsResponse();
        invalidCredentialsResponse.setError("Invalid token");
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(invalidCredentialsResponse));
    }

}
