package com.jj.shop.reactor;

import com.jj.shop.domain.User;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.function.Function;
@SpringBootTest
@Log
public class BaseRector {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void reactTest() {
        Flux<Integer> ints = Flux.range(1, 4);
        ints.subscribe(i -> System.out.println(i),
            error -> log.info("Error " + error),
            () -> log.info("Done"));
    }
    @Test
    public void reactMapTest() {
        Flux<String> ints = Flux.range(1, 4).map(fun);
        ints.subscribe((str) -> {
            System.out.println(str);
        }, error -> {
            System.out.println("Got error");
        });
    }

    Function<Integer,String> fun= (item) -> {
        String url = "http://localhost:8080/user/"+item;
        ResponseEntity<User> response = restTemplate.getForEntity(url,User.class);
        return response.getBody().getName();
    };



    @Test
    public void mySub() {
        MySub sub =  new <Integer> MySub();
        Flux<Integer> ints = Flux.range(1, 4);
        ints.subscribe(sub);
    }
}

class MySub<T> extends BaseSubscriber<T> {
    protected void hookOnNext(T value) {
        System.out.println("My subscriber is making"+value);
    }
}
