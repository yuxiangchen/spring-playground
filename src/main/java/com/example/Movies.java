package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by trainer8 on 4/23/17.
 */
@Service
@RestController
public class Movies {
    private final RestTemplate restTemplate = new RestTemplate();
    private static ObjectMapper objectMapper = new ObjectMapper();

//    @GetMapping("/movies")
//    public String getMoviesMap(@RequestParam String q) {
//        return this.restTemplate.getForObject(
//                "http://www.omdbapi.com/?s={q}",
//                String.class,
//                q
//        );
//    }

    @GetMapping("/movies")
    public String getMoviesMap(@RequestParam String q) throws Exception{
        JsonNode jsonOriginal = objectMapper.readTree
                (this.restTemplate.getForObject(
                "http://www.omdbapi.com/?s={q}",
                String.class,
                q
        ));

        ArrayNode search = (ArrayNode) jsonOriginal.get("Search");

        List<Map<String, Object>> result = new ArrayList<>();

        search.forEach(value -> {
            Map<String, Object> map = new HashMap<>();
            map.put("title", value.get("Title").textValue());
            map.put("imdbId", value.get("imdbID").textValue());
            map.put("year", Integer.parseInt(value.get("Year").textValue()));
            map.put("poster", value.get("Poster").textValue());
            result.add(map);
        });

        return objectMapper.writeValueAsString(result);
    }


}
