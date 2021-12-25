package com.budgetfriendly.bms.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class BaseConfiguration {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
