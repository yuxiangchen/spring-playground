package com.example;

import java.util.*;

/**
 * Created by trainer8 on 4/16/17.
 */
public class WordCounter {

    private final ConfigClass configClass;

    public WordCounter(ConfigClass configClass) {
        this.configClass = configClass;
    }

    public Map<String, Integer> count(String strings) {

        String spaceOnly = strings.replaceAll("[-+.^:,!?]"," ");
        if(configClass.isCaseSensitive() == false){
            spaceOnly = spaceOnly.toLowerCase();
        }
        String[] split = spaceOnly.split("\\s+");
        List<String> splitList = new ArrayList<>(Arrays.asList(split));
        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<splitList.size();i++) {
            for (String deleteCharacter : configClass.getWords().getSkip()) {
                splitList.remove(deleteCharacter);
            }
        }

        for(String s: splitList){
            if (map.containsKey(s)) {
                int count = map.get(s);
                map.put(s, count + 1);
            } else {
                map.put(s, 1);
            }
        }
        return map;
    }
}
