package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by trainer8 on 4/22/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {
        "wordCount.caseSensitive=false",
        "wordCount.words[0]=Hello",
        "wordCount.words[1]=there",
        "wordCount.words[2]=world",
})
public class ConfigClassTest {

    @Autowired private ConfigClass configClass;

    @Test
    public void testPropertiesAreMappedCorrectly() {
//        assertThat(configClass.isCaseSensitive(), false);
//        assertThat(configClass.getWords(), );
    }

}