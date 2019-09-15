package com.assignment.auth;

import com.assignment.user.UserEntity;
import com.assignment.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author shan
 * <p>
 * Authentication service implementation
 */
@Service
public class AuthenticateServiceImpl implements AuthenticateService {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticateServiceImpl.class);

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("Retrieving user for username : []", username);

        UserEntity userEntity = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("No users found"));

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return new UserPrincipal(userEntity);
    }

}
