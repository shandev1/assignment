package com.assignment.user;

import com.assignment.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username) {
        return userRepository.findById(username)
                .map(UserEntity::toUser)
                .orElseThrow(() -> new UserNotFoundException("No users found"));
    }
}
