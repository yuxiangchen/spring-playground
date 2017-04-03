package com.example;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.lang.Math.PI;


/**
 * Created by trainer8 on 4/2/17.
 */
@RestController
public class MathAreaController {
    @PostMapping("/math/area")
    public String showCycleOrRectangle(@RequestParam Map<String, String> formData){


        if(formData.containsValue("circle")){
            if(Integer.parseInt(formData.get("radius")) > 0) {
                Integer radius = Integer.parseInt(formData.get("radius"));
                return String.format("Area of a circle with a radius of %d is %f",
                        radius,
                        PI * Math.pow(radius, 2));
            } else
                return "Need the positive radius for calculating area";
        }

        if(formData.containsValue("rectangle")){

            if(Integer.parseInt(formData.get("width")) >0 &&
                    Integer.parseInt(formData.get("height"))>0 ) {
                Integer width = Integer.parseInt(formData.get("width"));
                Integer height = Integer.parseInt(formData.get("height"));
                return String.format("Area of a %d*%d rectangle is %d",
                        width,
                        height,
                        width * height);
            } else
                return "Need to positive height and width for calculating area";


        }

        return null;

    }


}
