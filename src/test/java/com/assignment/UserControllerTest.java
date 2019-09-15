package com.assignment;

import com.assignment.exceptions.UserNotFoundException;
import com.assignment.user.UserController;
import com.assignment.user.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .build();
    }

    @Test(expected = UserNotFoundException.class)
    public void shouldReturnNotFoundWhenInvalidUsername() throws Exception {
        when(userRepository.findById("test-user"))
                .thenThrow(new UserNotFoundException("No users found"));
        mockMvc.perform(get("/users/test-user")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
