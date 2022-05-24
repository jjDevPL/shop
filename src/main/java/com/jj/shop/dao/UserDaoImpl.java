package com.jj.shop.dao;

import com.jj.shop.domain.User;
import com.jj.shop.webflux.user.UserClient;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Log
public class UserDaoImpl implements UserDao {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

    public List<User> getUsers() {
        ResponseEntity<User[]> response = restTemplate.getForEntity("http://localhost:8080/users", User[].class);
        return Arrays.stream(response.getBody()).collect(Collectors.toList());

    }

    public User getUser(Long userId) {
       return  userClient.getUser(userId);
    }

    @Override
    public void addUser(User user) {
        user.setId(userClient.addUser(user).getId());

    }
}
