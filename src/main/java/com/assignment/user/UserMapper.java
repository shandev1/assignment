package com.assignment.user;

import org.springframework.stereotype.Component;

/**
 * @author shan
 * <p>
 * Utility class to map UserEntity to User DTO
 */
public class UserMapper {

    public User map(UserEntity userEntity) {
        User user = new User();
        user.setUsername(userEntity.getUsername());
        user.setFullName(userEntity.getFirstName() + " " + userEntity.getLastName());
        user.setPhoneNumber(userEntity.getCountryCode() + userEntity.getPhone());
        return user;
    }

}
