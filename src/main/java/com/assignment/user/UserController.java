package com.assignment.user;

import com.assignment.auth.AuthTokenHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author shan
 * <p>
 * This handles all the REST end points for User domain
 */
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AuthTokenHandler tokenProvider;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Authorizes a given user
     *
     * @param
     * @return
     */
    @PostMapping("/users")
    public ResponseEntity<UserLoginResponse> login(@Valid @RequestBody UserLoginRequest req) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new UserLoginResponse(jwt));
    }

    /**
     * Returns user for valid userName
     * Returns 404 if otherwise
     *
     * @param userName
     * @return
     */
    @GetMapping("/users/{userName}")
    public User getUser(@PathVariable String userName) {
        return userService.getUserByUsername(userName);
    }

}
