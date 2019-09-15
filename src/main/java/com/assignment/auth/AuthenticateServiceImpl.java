package com.assignment.auth;

import com.assignment.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("shan");
        userEntity.setPassword(passwordEncoder.encode("123"));
        UserPrincipal userPrincipal = new UserPrincipal(userEntity);
        return userPrincipal;
    }

}
