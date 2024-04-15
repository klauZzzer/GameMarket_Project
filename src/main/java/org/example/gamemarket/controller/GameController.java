package org.example.gamemarket.controller;

import lombok.RequiredArgsConstructor;
import org.example.gamemarket.entity.Game;
import org.example.gamemarket.request.CreateGameRequest;
import org.example.gamemarket.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("/get/{id}")
    public Game getGameById(@PathVariable("id") UUID id) {
        return gameService.getGameById(id);
    }

    @PostMapping("/createGame")
    public ResponseEntity<String> createGame(@RequestBody CreateGameRequest request) {
        return ResponseEntity.ok("Игра успешно создана");
    };

}
