package com.assignment.user;

import com.assignment.exceptions.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shan
 * <p>
 * This handles all the REST end points for User domain
 */
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Authorizes a given user
     *
     * @param
     * @return
     */
    @PostMapping("/users")
    public String login() {
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
    public UserEntity getUser(@PathVariable String userName) {
        return userRepository.findById(userName)
                .orElseThrow(() -> new UserNotFoundException("No users found"));

//        User user = new User();
//        user.setUsername("test user");
//        return user;
    }

}
