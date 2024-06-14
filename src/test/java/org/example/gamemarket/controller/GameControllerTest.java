package org.example.gamemarket.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gamemarket.dto.AfterCreationGameDto;
import org.example.gamemarket.dto.CreateGameDto;
import org.example.gamemarket.entity.Game;
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

import java.math.BigDecimal;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/db/dropTable.sql")
@Sql("/db/schemaTest.sql")
@Sql("/db/dataTest.sql")
@WithMockUser(value = "adminLogin", password = "admin123", roles = "ADMIN")
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getGameByIdTest() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/game/get/id/fc698b8c-f835-4800-b633-2f7905bfa238")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());

        String jsonResult = result.getResponse().getContentAsString();
        Game game = objectMapper.readValue(jsonResult, Game.class);
        Assertions.assertEquals("fc698b8c-f835-4800-b633-2f7905bfa238", game.getId().toString());
    }

    @Test
    public void getGameByNameTest() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/game/get/name/Grand Theft Auto V")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());

        String jsonResult = result.getResponse().getContentAsString();
        Game game = objectMapper.readValue(jsonResult, Game.class);
        Assertions.assertEquals("Grand Theft Auto V", game.getName());
    }

    @Test
    public void deleteGameById() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.delete("/game/delete/fc698b8c-f835-4800-b633-2f7905bfa238")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());

        result = mockMvc
                .perform(MockMvcRequestBuilders.get("/game/get/id/fc698b8c-f835-4800-b633-2f7905bfa238")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertEquals(404, result.getResponse().getStatus());
    }

    @Test
    public void updateGameTest() throws Exception {
        Game game = new Game();
        game.setPrice(BigDecimal.valueOf(89.99));
        game.setSales(2048);
        String gameDtoJson = objectMapper.writeValueAsString(game);
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/game/update/fc698b8c-f835-4800-b633-2f7905bfa238")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gameDtoJson))
                .andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());

        result = mockMvc
                .perform(MockMvcRequestBuilders.get("/game/get/id/fc698b8c-f835-4800-b633-2f7905bfa238")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String jsonResult = result.getResponse().getContentAsString();
        Game gameResult = objectMapper.readValue(jsonResult, Game.class);
        Assertions.assertEquals(game.getPrice(), gameResult.getPrice());
        Assertions.assertEquals(game.getSales(), gameResult.getSales());
    }

    @Test
    public void createGameTest() throws Exception {
        CreateGameDto createGameDto = new CreateGameDto();
        createGameDto.setName("Dota 3");
        createGameDto.setPrice(BigDecimal.valueOf(0.00));
        createGameDto.setDeveloper(null);
        createGameDto.setGenres(null);
        String json1 = objectMapper.writeValueAsString(createGameDto);
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/game/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json1))
                .andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());

        String jsonResult = result.getResponse().getContentAsString();
        AfterCreationGameDto gameResult = objectMapper.readValue(jsonResult, AfterCreationGameDto.class);
        result = mockMvc
                .perform(MockMvcRequestBuilders.get("/game/get/id/" + gameResult.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String json2 = result.getResponse().getContentAsString();
        Game game = objectMapper.readValue(json2, Game.class);
        Assertions.assertEquals(createGameDto.getName(), game.getName());
        Assertions.assertEquals(createGameDto.getDeveloper(), game.getDeveloper());
        Assertions.assertEquals(createGameDto.getGenres(), game.getGenres());
    }
}
