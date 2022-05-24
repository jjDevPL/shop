package com.jj.shop.webflux.user;

import com.jj.shop.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;


@Component
public class UserHandler {
    public Mono<ServerResponse> handle(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(new User()));
    }
}
