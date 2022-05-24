package com.jj.shop.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
@Component
@Scope(value=WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestService {
    public RequestService() {
        value=  new Long(11);
    }
    private Long value;

    public Long getValue() {
        return value;
    }

    public void setValue() {
        this.value++;
    }
}
