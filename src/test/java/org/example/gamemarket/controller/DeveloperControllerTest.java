package org.example.gamemarket.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gamemarket.dto.AfterCreationDeveloperDto;
import org.example.gamemarket.dto.CreateDeveloperDto;
import org.example.gamemarket.entity.Developer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/db/dropTable.sql")
@Sql("/db/schemaTest.sql")
@Sql("/db/dataTest.sql")
@WithMockUser(username = "adminLogin", password = "admin123", roles = "ADMIN")
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
        Developer developer = new Developer();
        developer.setName("Valve");
        developer.setCreationDate(LocalDate.parse("2006-11-09"));
        String developerDtoJson = objectMapper.writeValueAsString(developer);
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
        Assertions.assertEquals(developer.getName(), developerResult.getName());
        Assertions.assertEquals(developer.getCreationDate(), developerResult.getCreationDate());
    }

    @Test
    public void createDeveloperTest() throws Exception {
        CreateDeveloperDto createDeveloperDto = new CreateDeveloperDto("Valve", LocalDate.parse("2006-11-09"));
        String json1 = objectMapper.writeValueAsString(createDeveloperDto);
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/developer/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json1))
                .andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());

        String jsonResult = result.getResponse().getContentAsString();
        AfterCreationDeveloperDto developerResult = objectMapper.readValue(jsonResult, AfterCreationDeveloperDto.class);
        result = mockMvc
                .perform(MockMvcRequestBuilders.get("/developer/get/id/" + developerResult.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String json2 = result.getResponse().getContentAsString();
        Developer developer = objectMapper.readValue(json2, Developer.class);
        Assertions.assertEquals(createDeveloperDto.getName(), developer.getName());
        Assertions.assertEquals(createDeveloperDto.getCreationDate(), developer.getCreationDate());
    }
}
