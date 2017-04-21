package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by trainer8 on 4/15/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LessonsControllerTest {

    @Autowired
    MockMvc mvc;

    @Before
    @Transactional
    @Rollback
    public void setup() throws Exception {
        for (int i = 0; i < 5; ++i) {
            MockHttpServletRequestBuilder postRequest = post("/lessons")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"title\": \"JPA\"}");
            this.mvc.perform(postRequest).andExpect(status().isOk());
        }
    }


    @Test
    @Transactional
    @Rollback
    public void testCreate() throws Exception {
        MockHttpServletRequestBuilder request = get("/lessons/5")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("JPA")));
    }

    @Test
    @Transactional
    @Rollback
    public void testPatch() throws Exception {
        MockHttpServletRequestBuilder request = patch("/lessons/3")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":3,\"title\":\"Yuxiang Chen\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.title", is("Yuxiang Chen")));
    }

    @Test
    @Transactional
    @Rollback
    public void testDelete() throws Exception {
        MockHttpServletRequestBuilder request = delete("/lessons/5")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

}