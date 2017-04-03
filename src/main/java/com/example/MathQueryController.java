package com.example;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by trainer8 on 4/2/17.
 */
@RestController
public class MathQueryController {
    @GetMapping("/math/calculate")
    public String getIndividualParams(@RequestParam String operation,@RequestParam int x,@RequestParam int y){

        if(operation.equalsIgnoreCase("add") || operation.isEmpty()) {
            return String.format("%d + %d = %d", x, y, x + y);
        }

        if(operation.equalsIgnoreCase("multiply")) {
            return String.format("%d * %d = %d", x, y, x * y);
        }

        if(operation.equalsIgnoreCase("subtract")) {
            return String.format("%d - %d = %d", x, y, x - y);
        }

        if(operation.equalsIgnoreCase("divide") && y!=0) {
            return String.format("%d / %d = %d", x, y, x / y);
        }

        return null;
    }

    @PostMapping("/math/sum")
    public String getSum(@RequestParam MultiValueMap<String, String> queryString){

        List<String> values = queryString.get( "n" );

        String left = values.get(0) + " + ";
        int right = Integer.parseInt(values.get(0));
        for(int i=1;i<values.size();i++){
            left= left + String.format("%s + ", values.get(i));
            right = right + Integer.parseInt(values.get(i));
        }

        return left.substring(0,left.length()-2) + "= " + right;

    }

}
