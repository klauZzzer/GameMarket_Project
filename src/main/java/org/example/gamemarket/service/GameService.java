package org.example.gamemarket.service;

import org.example.gamemarket.entity.Game;

import java.util.UUID;


public interface GameService {
    Game getGameById(UUID id);

    Game createGame(String name);
}
