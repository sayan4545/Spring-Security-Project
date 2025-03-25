package com.devsayan.springsecurity.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfifg {

    @Bean
    public ModelMapper getMpdelMapper(){
        return new ModelMapper();
    }
}
