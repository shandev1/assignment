package com.assignment;

import com.assignment.auth.AuthenticateServiceImpl;
import com.assignment.auth.UserPrincipal;
import com.assignment.user.UserEntity;
import com.assignment.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class AuthenticationServiceTest {

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AuthenticateServiceImpl authenticateService;

    @Test
    public void shouldReturnAValidUserWhenValidUsernameIsGiven() {
        //Given
        UserEntity userEntity = createMockUserEntity();
        when(userRepository.findById(anyString())).thenReturn(Optional.of(userEntity));
        when(passwordEncoder.encode(anyString())).thenReturn(anyString());

        //When
        UserDetails user = authenticateService.loadUserByUsername(userEntity.getUsername());

        //Then
        UserPrincipal userPrincipal = (UserPrincipal) user;
        UserEntity returnedUser = userPrincipal.getUser();

        assertNotNull(returnedUser);
        assertEquals(userEntity.getUsername(), user.getUsername());
    }


    @Test(expected = UsernameNotFoundException.class)
    public void shouldReturnUserNotFoundExceptionWhenInValidUsernameIsGiven() {
        //Given
        when(userRepository.findById(anyString())).thenReturn(Optional.empty());

        //When & Then
        UserDetails user = authenticateService.loadUserByUsername(anyString());
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
