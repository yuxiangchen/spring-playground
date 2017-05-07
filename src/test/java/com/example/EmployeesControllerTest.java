package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by trainer8 on 5/7/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(SecurityConfig.class)
@AutoConfigureMockMvc(secure=false)
public class EmployeesControllerTest {
    @MockBean
    EmployeesRepository employeesRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    public void testWithEmployee() throws Exception {
        RequestBuilder requestBuilder = get("/admin/employees")
                .with(user("user").roles("EMPLOYEE"))
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(requestBuilder)
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$[0].salary").doesNotExist());
    }

    @Test
    public void testWithMangaer() throws Exception {
        RequestBuilder requestBuilder = get("/admin/employees")
                .with(user("user").roles("MANAGER"))
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.salary", is(24)));
    }

    @Test
    public void testWithNoOne() throws Exception {
        RequestBuilder requestBuilder = get("/admin/employees")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(requestBuilder)
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$[0].salary").doesNotExist());
    }
}