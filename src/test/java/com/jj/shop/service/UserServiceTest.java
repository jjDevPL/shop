package com.jj.shop.service;

import com.jj.shop.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles(value = "test")
class UserServiceTest {
    @Autowired
    private UserService userService;
    /*@Autowired
    private UserClient userClient;*/

    @Test
    public void testAddUSer() {
        String userName ="User One";
        User newUser =  new User();
        newUser.setName(userName);

        userService.addUser(newUser);
        User userFromDb = userService.getUser(newUser.getId());
        assertThat(userFromDb.getName()).isEqualTo(userName);
        assertThat(userFromDb.getId()).isNotZero();

    }

}
