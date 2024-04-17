package org.example.gamemarket.service;

import org.example.gamemarket.dto.AfterCreationGameDto;
import org.example.gamemarket.dto.CreateGameDto;
import org.example.gamemarket.entity.Game;

import java.util.UUID;


public interface GameService {
    Game getGameById(UUID id);

    AfterCreationGameDto createGame(CreateGameDto createGameDto);
}
