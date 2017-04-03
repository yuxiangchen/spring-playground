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
 * Created by trainer8 on 3/30/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(MathQueryController.class)

public class MathQueryControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testAdd() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/math/calculate?operation=add&x=4&y=6");

        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 6 = 10"));
    }

    @Test
    public void testMultiply() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/math/calculate?operation=multiply&x=4&y=6");

        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("4 * 6 = 24"));
    }

    @Test
    public void testSubtract() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/math/calculate?operation=subtract&x=4&y=6");

        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("4 - 6 = -2"));
    }

    @Test
    public void testDivide() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/math/calculate?operation=divide&x=30&y=5");

        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("30 / 5 = 6"));
    }

    @Test
    public void testSum() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/math/sum?n=4&n=5&n=6");

        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 5 + 6 = 15"));
    }

}