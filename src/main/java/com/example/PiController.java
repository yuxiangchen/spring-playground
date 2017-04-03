package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by trainer8 on 3/30/17.
 */
@RestController
public class PiController {

    @GetMapping("/math/pi")
    public String sayPi() {
        return "3.141592653589793";
    }
}
