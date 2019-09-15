package com.assignment;

import com.assignment.exceptions.UserNotFoundException;
import com.assignment.user.User;
import com.assignment.user.UserEntity;
import com.assignment.user.UserRepository;
import com.assignment.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void shouldReturnAValidUserWhenValidUsernameIsGiven() {
        //Given
        UserEntity userEntity = createMockUserEntity();
        when(userRepository.findById(anyString())).thenReturn(Optional.of(userEntity));

        //When
        User user = userService.getUserByUsername(userEntity.getUsername());

        //Then
        assertEquals(userEntity.getUsername(), user.getUsername());
        assertEquals(userEntity.getFirstName(), user.getFirstName());
        assertEquals(userEntity.getLastName(), user.getLastName());
        assertEquals(userEntity.getPassword(), user.getPassword());
        assertEquals(userEntity.getPhone(), user.getPhone());
    }


    @Test(expected = UserNotFoundException.class)
    public void shouldReturnUserNotFoundExceptionWhenInValidUsernameIsGiven() {
        //Given
        when(userRepository.findById(anyString())).thenReturn(Optional.empty());

        //When & Then
        User user = userService.getUserByUsername(anyString());
    }

    private UserEntity createMockUserEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("username");
        userEntity.setFirstName("firstName");
        userEntity.setLastName("lastName");
        userEntity.setPassword("password");
        userEntity.setPhone("phone");
        return userEntity;
    }
}