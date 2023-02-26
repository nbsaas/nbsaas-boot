package com.nbsaas.hibernate;

import org.springframework.stereotype.Service;

@Service
public class HelloResource implements HelloApi {
    @Override
    public void show(String msg) {
        System.out.println(msg);
    }
}
