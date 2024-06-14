package org.example.gamemarket.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gamemarket.entity.UserInfo;
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

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/db/dropTable.sql")
@Sql("/db/schemaTest.sql")
@Sql("/db/dataTest.sql")
@WithMockUser(username = "adminLogin", password = "admin123", roles = "ADMIN")
public class UserInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getUserInfoByIdTest() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/userInfo/get/id/fc698b8c-f835-4800-b633-2f7905bfa238")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());

        String jsonResult = result.getResponse().getContentAsString();
        UserInfo userInfo = objectMapper.readValue(jsonResult, UserInfo.class);
        Assertions.assertEquals("fc698b8c-f835-4800-b633-2f7905bfa238", userInfo.getId().toString());
    }

    @Test
    public void getUserInfoByLoginTest() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/userInfo/get/login/adminLogin")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());

        String jsonResult = result.getResponse().getContentAsString();
        UserInfo userInfo = objectMapper.readValue(jsonResult, UserInfo.class);
        Assertions.assertEquals("adminLogin", userInfo.getLogin());
    }
}
