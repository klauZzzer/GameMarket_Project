package org.example.gamemarket.service.interfaces;

import org.example.gamemarket.dto.AfterCreationGameDto;
import org.example.gamemarket.dto.CreateGameDto;
import org.example.gamemarket.entity.Game;

import java.util.UUID;


public interface GameService {
    Game getGameById(UUID id);

    Game getGameByName(String name);

    void deleteGameById(UUID id);

    void updateGameById(UUID id, Game updatedGame);

    AfterCreationGameDto createGame(CreateGameDto createGameDto);
}
