package org.example.gamemarket.service.impl;
import lombok.RequiredArgsConstructor;
import org.example.gamemarket.dto.AfterCreationGameDto;
import org.example.gamemarket.dto.CreateGameDto;
import org.example.gamemarket.entity.Game;
import org.example.gamemarket.mapper.GameMapper;
import org.example.gamemarket.repository.GameRepository;
import org.example.gamemarket.service.GameService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    @Override
    public Game getGameById(UUID id) {
        return gameRepository.findGameById(id);
    }

    @Override
    public AfterCreationGameDto createGame(CreateGameDto createGameDto) {
        Game game = gameRepository.findGameByName(createGameDto.getName());
        if (game != null) {
        }
        Game entity = gameMapper.toEntity(createGameDto);
        Game afterCreationGame = gameRepository.save(entity);
        return gameMapper.toDto(afterCreationGame);
    }
}
