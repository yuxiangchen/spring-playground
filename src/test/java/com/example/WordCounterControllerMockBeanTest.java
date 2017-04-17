package com.example;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by trainer8 on 4/16/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest({WordCounterController.class, ConfigClass.class})
public class WordCounterControllerMockBeanTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WordCounter wordCounter;

    @Test
    public void testMock() throws Exception{
        Map<String, Integer> mockResult = new HashMap<String, Integer>() {
            {
                put("to", 2);
                put("the", 2);
                put("moon", 2);
            }
        };

////        need to figure out why.
        when(wordCounter.count("to the moon, to the moon"))
                .thenReturn(mockResult);

//        assertEquals(wordCounter.count("to the moon, to the moon"),mockResult);

        mockMvc.perform(post("/words/count").content("to the moon, to the moon"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.to", is(2)))
                .andExpect(jsonPath("$.the", is(2)))
                .andExpect(jsonPath("$.moon", is(2)));


        MockHttpServletRequestBuilder requestBuilder = post("/words/count")
                .contentType(MediaType.APPLICATION_JSON)
                .content("to the moon, to the moon");

        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.to", Matchers.is(2)))
                .andExpect(jsonPath("$.the", Matchers.is(2)))
                .andExpect(jsonPath("$.moon", Matchers.is(2)));
    }
}