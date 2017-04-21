package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by trainer8 on 4/16/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest({WordCounterController.class, ConfigClass.class})
public class WordCounterControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testWordCounterController() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = post("/words/count")
                .contentType(MediaType.APPLICATION_JSON)
                .content("to the moon, to the moon");

        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.to", is(2)))
                .andExpect(jsonPath("$.moon", is(2)));
    }
}