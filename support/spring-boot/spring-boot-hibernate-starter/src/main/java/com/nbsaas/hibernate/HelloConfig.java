package com.nbsaas.hibernate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {

    @Bean
    public HelloResource helloResource(){
        return new HelloResource();
    }
}
