package org.example.gamemarket.service.impl;
import lombok.RequiredArgsConstructor;
import org.example.gamemarket.entity.Game;
import org.example.gamemarket.repository.GameRepository;
import org.example.gamemarket.service.GameService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Override
    public Game getGameById(UUID id) {
        return gameRepository.findGameById(id);
    }

    @Override
    public Game createGame(Game game) {
        return gameRepository.save(game);
    }
}
