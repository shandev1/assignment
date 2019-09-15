package com.assignment.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author shan
 * <p>
 * Login request
 */
@Getter
@Setter
@ToString
public class UserLoginRequest {
    private String username;
    private String password;
}
