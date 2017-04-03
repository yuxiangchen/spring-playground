package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by trainer8 on 4/3/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MathVolumeController.class)
public class MathVolumeControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testVolumnwithGetPath() throws Exception {
        int length = 3;
        int width = 4;
        int height = 5;

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/math/volume/3/4/5",
                length,width,height);
        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));
    }

    @Test
    public void testVolumnwithPostPath() throws Exception {
        int length = 3;
        int width = 4;
        int height = 5;

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/math/volume/3/4/5",
                length,width,height);
        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));
    }
}