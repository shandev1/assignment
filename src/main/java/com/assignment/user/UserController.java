package com.assignment.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String login(@RequestBody User user) {
        return "token";
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
