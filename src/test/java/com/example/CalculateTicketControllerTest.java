package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.example.CalculateTicketController.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by trainer8 on 4/5/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CalculateTicketController.class)
public class CalculateTicketControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testCalculateTicketStringTest() throws Exception {
        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{    \"tickets\": [\n" +
                        "      {\n" +
                        "        \"passenger\": {\n" +
                        "          \"firstName\": \"Some name\",\n" +
                        "          \"lastName\": \"Some other name\"\n" +
                        "        },\n" +
                        "        \"price\": 200\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"passenger\": {\n" +
                        "          \"firstName\": \"Name B\",\n" +
                        "          \"lastName\": \"Name C\"\n" +
                        "        },\n" +
                        "        \"price\": 150\n" +
                        "      }\n" +
                        "    ]}");

    this.mvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result",is(350)));
    }

    @Test
    public void testCalculateTicketGsonTest() throws Exception {

        Tickets[] tickets = new Tickets[2];
        tickets[0] = new Tickets(new Passenger("Some name","Some other name"),200);
        tickets[1] = new Tickets(new Passenger("Name B","Name C"),150);
        Total total = new Total(tickets);

        Gson builder = new GsonBuilder().create();

        String jsonString = builder.toJson(total);

        MockHttpServletRequestBuilder requestBuilder = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString);

        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result",is(350)));
    }

    @Test
    public void testCalculateTicketFileTest() throws Exception {
        String json = getJSON("/data.json");

        MockHttpServletRequestBuilder requestBuilder = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result",is(350)));
    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }
}