package com.assignment.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author shan
 * <p>
 * User authentication service
 */
public interface AuthenticateService extends UserDetailsService {

    UserDetails loadUserByUsername(String username);

}
