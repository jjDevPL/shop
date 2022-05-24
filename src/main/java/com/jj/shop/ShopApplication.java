package com.jj.shop;

import com.jj.shop.service.DefaultBean;
import com.jj.shop.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;

@SpringBootApplication
@EnableAsync
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

    @Bean
    @Scope("prototype")
    public DefaultBean buildDeafultBean() {
        return new DefaultBean();
    }






    @Bean
    RestTemplate restTemplate() {
	    return new RestTemplate();
    }
}
