package org.example.gamemarket.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gamemarket.dto.AfterCreationDeveloperDto;
import org.example.gamemarket.dto.CreateDeveloperDto;
import org.example.gamemarket.entity.Developer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/db/schemaTest.sql")
@Sql("/db/dataTest.sql")
public class DeveloperControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getDeveloperByIdTest() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/developer/get/id/fc698b8c-f835-4800-b633-2f7905bfa238")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());

        String jsonResult = result.getResponse().getContentAsString();
        Developer developer = objectMapper.readValue(jsonResult, Developer.class);
        Assertions.assertEquals("fc698b8c-f835-4800-b633-2f7905bfa238", developer.getId().toString());
    }

    @Test
    public void getDeveloperByNameTest() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/developer/get/name/Ubisoft")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());

        String jsonResult = result.getResponse().getContentAsString();
        Developer developer = objectMapper.readValue(jsonResult, Developer.class);
        Assertions.assertEquals("Ubisoft", developer.getName());
    }

    @Test
    public void deleteDeveloperById() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.delete("/developer/delete/fc698b8c-f835-4800-b633-2f7905bfa238")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());

        result = mockMvc
                .perform(MockMvcRequestBuilders.get("/developer/get/id/fc698b8c-f835-4800-b633-2f7905bfa238")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertEquals(404, result.getResponse().getStatus());
    }

    @Test
    public void updateDeveloperTest() throws Exception {
        CreateDeveloperDto developerDto = new CreateDeveloperDto();
        developerDto.setName("Valve");
        developerDto.setCreationDate(LocalDate.parse("2006-11-09"));
        String developerDtoJson = objectMapper.writeValueAsString(developerDto);
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/developer/update/fc698b8c-f835-4800-b633-2f7905bfa238")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(developerDtoJson))
                .andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());

        result = mockMvc
                .perform(MockMvcRequestBuilders.get("/developer/get/id/fc698b8c-f835-4800-b633-2f7905bfa238")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String jsonResult = result.getResponse().getContentAsString();
        Developer developerResult = objectMapper.readValue(jsonResult, Developer.class);
        Assertions.assertEquals(developerDto.getName(), developerResult.getName());
        Assertions.assertEquals(developerDto.getCreationDate(), developerResult.getCreationDate());
    }

    @Test
    public void createDeveloperTest() throws Exception {
        CreateDeveloperDto createDeveloperDto = new CreateDeveloperDto();
        createDeveloperDto.setName("Valve");
        createDeveloperDto.setCreationDate(LocalDate.parse("2006-11-09"));
        String json = objectMapper.writeValueAsString(createDeveloperDto);
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/developer/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());

        String jsonResult = result.getResponse().getContentAsString();
        Developer developerResult = objectMapper.readValue(jsonResult, Developer.class);
        Assertions.assertEquals(createDeveloperDto.getName(), developerResult.getName());
        Assertions.assertEquals(createDeveloperDto.getCreationDate(), developerResult.getCreationDate());
    }



}
