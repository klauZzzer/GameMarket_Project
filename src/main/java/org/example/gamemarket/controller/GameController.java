package org.example.gamemarket.controller;

import lombok.RequiredArgsConstructor;
import org.example.gamemarket.entity.Game;
import org.example.gamemarket.service.impl.GameServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    private final GameServiceImpl gameService;

    @GetMapping("/get/{id}")
    public Game getGameById(@PathVariable("id") UUID id) {
        return gameService.getGameById(id);
    }

}
