package org.abhi.springbottmockito.Controllers;

import org.abhi.springbottmockito.Entity.Office;
import org.abhi.springbottmockito.Service.OfficeService;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(OfficeController.class)
class OfficeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OfficeService officeService;
    @Test
    void findAll() throws Exception {

        when(officeService.findAll()).thenReturn(
                Arrays.asList(new Office(1,"Pilot","The documentary crew begins filming the employees at Dunder Mifflin, capturing their daily interactions and unique personalities.",8.6,1),
                        new Office(2,"Diversity Day","In response to a diversity training seminar, Michael engages in inappropriate behavior, leading to a day of awkwardness at the office.",8.3,1))
        );

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/office/findAll").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{ \"episode\": 1, \"name\": \"Pilot\", \"description\": \"The documentary crew begins filming the employees at Dunder Mifflin, capturing their daily interactions and unique personalities.\", \"rating\": 8.6, \"season\": 1 }, { \"episode\": 2, \"name\": \"Diversity Day\", \"description\": \"In response to a diversity training seminar, Michael engages in inappropriate behavior, leading to a day of awkwardness at the office.\", \"rating\": 8.3, \"season\": 1 }]"))
                .andReturn();

    }

    @Test
    void findByEpisode() {
    }

    @Test
    void saveOffice() {
    }

    @Test
    void updateOffice() {
    }

    @Test
    void deleteOffice() {
    }
}