package org.abhi.springbottmockito.Controllers;

import org.abhi.springbottmockito.Entity.Item;
import org.abhi.springbottmockito.Service.ItemService;
import org.apache.coyote.Request;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private ItemService itemService;

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
    @Test
    void dummyItem() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/dummy-item").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();

    }

    @Test
    void JsonAssertTest_StrictTrue_ExactMatch_ExceptSpaces() throws JSONException {

        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,true);

    }

    @Test
    void JsonAssertTest_StrictFalse() throws JSONException {

        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,false);
    }

    @Test
    void serviceItemTest() throws Exception {

        when(itemService.retrieveHardCodedItem()).thenReturn(
                new Item(2,"Item 2",10,10)
        );

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/serviceItem").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":2,\"name\":\"Item 2\",\"price\":10,\"quantity\":10}"))
                .andReturn();

    }
}