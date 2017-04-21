package com.example;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by trainer8 on 4/16/17.
 */
@RestController
public class WordCounterController {

    private final WordCounter wordCounter;

    public WordCounterController(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    @PostMapping ("/words/count")
    public Map<String, Integer> count (@RequestBody String word){

        return wordCounter.count(word);
    }
}
