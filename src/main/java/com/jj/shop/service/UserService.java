package com.jj.shop.service;

import com.jj.shop.webflux.user.UserClient;
import com.jj.shop.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

public interface UserService {
    User getUser(Long id);
    List<User> getAllUsers();
    void addUser(User user);
}
