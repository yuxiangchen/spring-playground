package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by trainer8 on 4/16/17.
 */
@Component
@ConfigurationProperties("wordCount")
public class ConfigClass {

    @Bean
    public WordCounter wordCounter(ConfigClass configClass){
        return new WordCounter(configClass);
    }

    private boolean caseSensitive;
    private Words words;

    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    public void setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    public Words getWords() {
        return words;
    }

    public void setWords(Words words) {
        this.words = words;
    }

    @ConfigurationProperties(prefix = "wordCount.words")
    public static class Words{
        private List<String> skip;

        public List<String> getSkip() {
            return skip;
        }

        public void setSkip(List<String> skip) {
            this.skip = skip;
        }
    }




}
