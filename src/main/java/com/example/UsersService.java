package com.example;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by trainer8 on 4/26/17.
 */
@Service
public class UsersService {
    private final UsersServiceConfig config;
    private final RestTemplate restTemplate = new RestTemplate();

    public UsersService(UsersServiceConfig config) {
        this.config = config;
    }

    public RestTemplate getRestTemplate() {
        return this.restTemplate;
    }

//    public User createUser(User inputUser) {
//        HttpHeader headers = new HttpHeaders();
//
//
//    }

    public String getCount(){
        String response = this.restTemplate.getForObject(String.format("%s/users/count",
                this.config.getUrl()), String.class);

//        String res = "{\""

        return String.format("There are %s users", response);
//        return res;
    }
}
