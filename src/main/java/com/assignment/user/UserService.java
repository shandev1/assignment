package com.assignment.user;

import com.assignment.exceptions.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shan
 * <p>
 * User service implementation
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    /**
     * Retrieves user for given username
     *
     * @param username
     * @return
     */
    public User getUserByUsername(String username) {

        logger.info("Retrieving user for : []", username);

        UserMapper mapper = new UserMapper();

        return userRepository.findById(username)
                .map(mapper::map)
                .orElseThrow(() -> new UserNotFoundException("No users found"));
    }
}
