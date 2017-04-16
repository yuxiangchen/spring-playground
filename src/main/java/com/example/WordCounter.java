package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by trainer8 on 4/16/17.
 */
public class WordCounter {

    public Map<String, Integer> count(String strings) {

        String spaceOnly = strings.replaceAll("[-+.^:,!?]"," ");
        String [] split = spaceOnly.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for(String s: split){
            if(map.containsKey(s)){
                int count = map.get(s);
                map.put(s,count + 1);
            }else {
                map.put(s, 1);
            }
        }
        return map;
    }
}
