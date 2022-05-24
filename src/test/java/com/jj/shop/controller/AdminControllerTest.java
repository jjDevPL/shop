package com.jj.shop.controller;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.jj.shop.domain.User;
import com.jj.shop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@WireMockTest(httpPort = 8080)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
class AdminControllerTest {
    @Autowired
    UserService userService;
    @Test
    public void basci() {
      /*  stubFor(get("/users").willReturn(aResponse().withBody(
            "[{\"id\":1,\"name\":\"pierwszy\"},{\"id\":2,\"name\":\"stub\"}]"

        ).withHeader("Content-Type","application/json")));*/
       /* List<User> list = userService.getUsers();*/
        int z=90;

    }
}
