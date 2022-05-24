package com.jj.shop.webflux.user;

import com.jj.shop.domain.NullUser;
import com.jj.shop.domain.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Component
@Log
public class UserClient {
    @Value("${external.userservice.url}")
    private String serviceUrl;

    private WebClient client;
    @Autowired
    private WebClient.Builder builder;

    // Spring Boot auto-configures a `WebClient.Builder` instance with nice defaults and customizations.
    // We can use it to create a dedicated `WebClient` for our component.
    public UserClient() {
        /*serviceUrl = env.getProperty("external.userservice.url");*/

    }
    @PostConstruct
    void config() {
        this.client = builder.baseUrl(serviceUrl).build();
    }

    public User getUser(Long userId) {
        return this.client.get().uri("/user/"+userId).accept(MediaType.APPLICATION_JSON)
            .retrieve().bodyToMono(User.class).onErrorReturn(new NullUser()).block();
    }
    public User addUser(User user) {
        return  this.client.post().uri("/user/new").bodyValue(user).retrieve().bodyToMono(User.class).block();
    }
}
