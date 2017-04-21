package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by trainer8 on 4/16/17.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class WordCounterTest {

    @Autowired WordCounter wordCounter;

    @Test
    public void testCount() {
        String testString = "to the moon, to the moon";

        Map<String,Integer> map = new HashMap<>();

        map.put("moon",2);
        map.put("to",2);

        assertEquals(map,wordCounter.count(testString));
    }
}