package com.example;

import org.springframework.stereotype.Component;

/**
 * Created by trainer8 on 4/23/17.
 */
@Component
public class MovieConfig {
    private String host;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
