package com.jj.shop.dao;

import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.jj.shop.domain.NullUser;
import com.jj.shop.domain.User;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;
import wiremock.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureWireMock(port = 8080, stubs = "classpath:/mappings")
class UserDaoImplWithWireMockTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void testGetUsers() {
        List<User> users = userDao.getUsers();
        assertThat (users).isNotNull();
        assertThat (users.get(0).getName()).isEqualTo("nick");
    }
    @Test
    public void testGetUser() {
        User user = userDao.getUser(1l);
        assertThat(user).isNotNull();
        assertThat(user.getId()).isEqualTo(1);
        assertThat(user.getName()).isEqualTo("UserOne");

    }

    @Test
    public void testGetUserWithError() {
        stubFor(get("/user/1").withPort(8080)
            .willReturn(aResponse().withStatus(404)));
        User user = userDao.getUser(1l);
        assertThat(user).isNotNull();
        assertThat(user).isInstanceOf(NullUser.class);
        assertThat(user.getId()).isNull();
        assertThat(user.getName()).isNull();

    }
    @SneakyThrows
    @Test
    public void testAddUser() {
        Long id = 1l;
        User user = new User();
        user.setName("newName");
        ObjectMapper objectMapper= new ObjectMapper();

        String jsonWithoutId = objectMapper.writeValueAsString(user);
        user.setId(id);
        String returendJson = objectMapper.writeValueAsString(user);

        stubFor(post("/user/new").withRequestBody(equalToJson(jsonWithoutId))
            .withPort(8080)
            .withHeader("Content-Type", equalTo("application/json"))
            .willReturn(
                aResponse().withBody(returendJson).withHeader("Content-Type", "application/json"))
        );
        user.setId(null);
        userDao.addUser(user);
        assertThat(user.getId()).isEqualTo(id);
    }

    @SneakyThrows
    @Test
    public void json() {
        User user = new User();
        user.setName("newName");
        ObjectMapper objectMapper= new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        assertThat(json).isNotBlank();

    }




}
