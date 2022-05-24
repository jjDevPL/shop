package com.jj.shop.controller;

import com.jj.shop.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @Autowired
    private RequestService requestService;
    @GetMapping("/req")
    public void cos() {
        System.out.println("Request controller "+requestService.getValue());
    }
}
