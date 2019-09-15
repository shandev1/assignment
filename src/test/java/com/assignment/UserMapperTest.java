package com.assignment;

import com.assignment.user.User;
import com.assignment.user.UserEntity;
import com.assignment.user.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Test
    public void shouldReturnAValidUserWhenValidUsernameIsGiven() {
        UserEntity userEntity = createMockUserEntity();

        UserMapper mapper = new UserMapper();

        User user = mapper.map(userEntity);

        String fullName = userEntity.getFirstName() + " " + userEntity.getLastName();
        String phone = userEntity.getCountryCode() + userEntity.getPhone();

        assertEquals(userEntity.getUsername(), user.getUsername());
        assertEquals(fullName, user.getFullName());
        assertEquals(phone, user.getPhoneNumber());
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
