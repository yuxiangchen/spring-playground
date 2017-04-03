package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by trainer8 on 4/2/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MathAreaController.class)
public class MathAreaControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testAreaWithCircle() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = post("/math/area")
                .param("type", "circle")
                .param("radius", "4");

        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("Area of a circle with a radius of 4 is 50.265482"));
    }

    @Test
    public void testAreaWithRectangle() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = post("/math/area")
                .param("type", "rectangle")
                .param("width", "4")
                .param("height", "7");

        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("Area of a 4*7 rectangle is 28"));
    }


    @Test
    public void testAreaWithCycleNegative() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = post("/math/area")
                .param("type", "circle")
                .param("radius", "-4");

        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("Need the positive radius for calculating area"));
    }

    @Test
    public void testAreaWithRectangleNegative() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = post("/math/area")
                .param("type", "rectangle")
                .param("width", "-4")
                .param("height", "-7");

        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("Need to positive height and width for calculating area"));
    }

}