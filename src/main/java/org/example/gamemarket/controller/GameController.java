package org.example.gamemarket.controller;

import lombok.RequiredArgsConstructor;
import org.example.gamemarket.annotation.*;
import org.example.gamemarket.dto.AfterCreationGameDto;
import org.example.gamemarket.dto.CreateGameDto;
import org.example.gamemarket.entity.Game;
import org.example.gamemarket.service.interfaces.GameService;
import org.example.gamemarket.validation.annotation.UUIDFormatChecker;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Validated
@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetGameById(path = "/get/id/{id}")
    public Game getGameById(@UUIDFormatChecker @PathVariable("id") UUID id) {
        return gameService.getGameById(id);
    }

    @GetGameByName(path = "/get/name/{name}")
    public Game getGameByName(@PathVariable("name") String name) {
        return gameService.getGameByName(name);
    }

    @DeleteGameById(path = "/delete/{id}")
    public void deleteGameById(@UUIDFormatChecker @PathVariable("id") UUID id) {
        gameService.deleteGameById(id);
    }

    @UpdateGameById(path = "/update/{id}")
    public void updateGameById(@UUIDFormatChecker @PathVariable("id") UUID id, @RequestBody Game updatedGame) {
        gameService.updateGameById(id, updatedGame);
    }

    @CreateGame(path = "/create")
    public AfterCreationGameDto createGame(@RequestBody CreateGameDto createGameDto) {
        return gameService.createGame(createGameDto);
    }

}
