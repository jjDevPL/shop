package com.jj.shop.webflux.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration(proxyBeanMethods = false)
public class WebFluxRouter {
    @Bean
    public RouterFunction<ServerResponse> route(UserHandler userHandler) {
        return RouterFunctions
            .route()
            .GET("/user/{id}",accept(MediaType.APPLICATION_JSON), userHandler::handle)
            .POST("/user/new",accept(MediaType.APPLICATION_JSON),userHandler::handle).build();
    }
}
