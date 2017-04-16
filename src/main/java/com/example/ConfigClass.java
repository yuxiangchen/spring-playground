package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by trainer8 on 4/16/17.
 */
@Configuration
public class ConfigClass {

    @Bean
    public WordCounter counter(){
        return new WordCounter();
    }

}
