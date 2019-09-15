package com.assignment.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author shan
 * <p>
 * User DTO
 */
@NoArgsConstructor
@Getter
@Setter
public class User {
    private String username;
    private String fullName;
    private String phoneNumber;
}