package com.jj.shop.dao;

import com.jj.shop.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> getUsers();
    public User getUser(Long userId);
    public void addUser(User user);
}
