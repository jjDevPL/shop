package com.jj.shop.service;

import com.jj.shop.dao.UserDao;
import com.jj.shop.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getUsers();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
