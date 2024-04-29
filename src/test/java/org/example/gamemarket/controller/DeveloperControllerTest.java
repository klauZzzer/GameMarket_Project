package org.example.gamemarket.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gamemarket.dto.AfterCreationDeveloperDto;
import org.example.gamemarket.dto.CreateDeveloperDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("db/schemaTest.sql")
@Sql("db/dataTest.sql")
public class DeveloperControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createDeveloperPositiveTest() throws Exception {
        CreateDeveloperDto createDeveloperDto = new CreateDeveloperDto();
        String json = objectMapper.writeValueAsString(createDeveloperDto);
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("developer/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();
        String jsonResult = result.getResponse().getContentAsString();
        AfterCreationDeveloperDto creationDeveloperDto = objectMapper.readValue(jsonResult, AfterCreationDeveloperDto.class);
        Assertions.assertEquals(200, result.getResponse().getStatus());
    }



}
