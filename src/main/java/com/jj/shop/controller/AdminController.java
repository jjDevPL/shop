package com.jj.shop.controller;

import com.jj.shop.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jj.shop.service.UserService;

import java.util.List;

@RestController
public class AdminController {
    private UserService userService;
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/show")
    public List<User> show() {
     /*   requestService.setValue();
        System.out.println("Admin controller"+requestService.getValue());*/
        return null;
    }
}
