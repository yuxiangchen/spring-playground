package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
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
@WebMvcTest(PiController.class)
@AutoConfigureMockMvc(secure=false)
public class PiControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testHomepage() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/math/pi");

        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
    }

}
