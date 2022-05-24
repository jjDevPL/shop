package com.jj.shop.dao;

import com.jj.shop.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles(value = "test")
class UserDaoImplTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void testUsersGe() {
        List<User> users = userDao.getUsers();
        assertThat (users).isNotNull();
        assertThat (users.get(0).getName()).isEqualTo("nick");
    }
    @Test
    public void testGetUser() {
        User user = userDao.getUser(1l);
        assertThat(user).isNotNull();
        assertThat(user.getId()).isEqualTo(1);
        assertThat(user.getName()).isEqualTo("nick");

    }
}
