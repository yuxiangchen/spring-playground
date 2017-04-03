package com.example;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by trainer8 on 4/3/17.
 */
@RestController
public class MathVolumeController {
    @RequestMapping(value = "/math/volume/{length}/{width}/{height}")
    public String getIndividualParams(@PathVariable int length,
                                      @PathVariable int width,
                                      @PathVariable int height){
        return String.format("The volume of a %dx%dx%d rectangle is %d",
                length,
                width,
                height,
                length*width*height);
    }
}
