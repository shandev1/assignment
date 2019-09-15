package com.assignment.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticateService extends UserDetailsService {

    UserDetails loadUserByUsername(String s);

}
