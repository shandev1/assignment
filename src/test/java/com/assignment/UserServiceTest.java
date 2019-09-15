package com.assignment;

import com.assignment.exceptions.UserNotFoundException;
import com.assignment.user.User;
import com.assignment.user.UserEntity;
import com.assignment.user.UserRepository;
import com.assignment.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test(expected = UserNotFoundException.class)
    public void shouldReturnNotFoundWhenInvalidUsernameIsGiven() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("shan");
        when(userRepository.findById("shan")).thenReturn(Optional.of(userEntity));

        User user = userService.getUserByUsername("shan");
        assertEquals(userEntity.getUsername(), user.getUsername());
    }
}
