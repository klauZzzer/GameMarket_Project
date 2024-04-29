package org.example.gamemarket.controller;

import lombok.RequiredArgsConstructor;
import org.example.gamemarket.dto.AfterCreationDeveloperDto;
import org.example.gamemarket.dto.AfterCreationGameDto;
import org.example.gamemarket.dto.CreateDeveloperDto;
import org.example.gamemarket.dto.CreateGameDto;
import org.example.gamemarket.entity.Developer;
import org.example.gamemarket.entity.Game;
import org.example.gamemarket.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("/get/id/{id}")
    public Game getGameById(@PathVariable("id") UUID id) {
        return gameService.getGameById(id);
    }

    @GetMapping("/get/name/{name}")
    public Game getGameByName(@PathVariable("name") String name) {
        return gameService.getGameByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGameById(@PathVariable("id") UUID id) {
        gameService.deleteGameById(id);
    }

    @PostMapping("/update/{id}")
    public void updateGameById(@PathVariable("id") UUID id, @RequestBody Game updatedGame) {
        gameService.updateGameById(id, updatedGame);
    }

    @PostMapping("/create")
    public AfterCreationGameDto createGame(@RequestBody CreateGameDto createGameDto) {
        return gameService.createGame(createGameDto);
    }

}
