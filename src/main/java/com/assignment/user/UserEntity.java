package com.assignment.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author shan
 * <p>
 * This is an domain class to represent User
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "User")
public class UserEntity {

    @Id
    private String username;

    private String password;
    private String firstName;
    private String lastName;
    private String phone;

    public User toUser() {
        return new User();
    }

}
