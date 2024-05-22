package org.example.gamemarket.service.impl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.gamemarket.dto.AfterCreationGameDto;
import org.example.gamemarket.dto.CreateGameDto;
import org.example.gamemarket.entity.Developer;
import org.example.gamemarket.entity.Game;
import org.example.gamemarket.entity.Review;
import org.example.gamemarket.exception.*;
import org.example.gamemarket.mapper.GameMapper;
import org.example.gamemarket.repository.DeveloperRepository;
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
    public Game getGameByName(String name) {
        return gameRepository.findGameByName(name);
    }

    @Override
    @Transactional
    public void deleteGameById(UUID id) {
        Game game = gameRepository.findGameById(id);
        if (game == null) {
            throw new GameDoesNotExistException(ErrorMessage.THIS_GAME_DOES_NOT_EXIST);
        }
        gameRepository.deleteById(id);
    }

    @Override
    public void updateGameById(UUID id, Game updatedGame) {
        Game game = gameRepository.findGameById(id);
        if (game == null) {
            throw new GameDoesNotExistException(ErrorMessage.THIS_GAME_DOES_NOT_EXIST);
        }
        updatedGame.setId(game.getId());
        if (updatedGame.getName() == null) {
            updatedGame.setName(game.getName());
        }
        if (updatedGame.getOverallRating() == null) {
            updatedGame.setOverallRating(game.getOverallRating());
        }
        if (updatedGame.getPrice() == null) {
            updatedGame.setPrice(game.getPrice());
        }
        if (updatedGame.getSales() == null) {
            updatedGame.setSales(game.getSales());
        }
        if (updatedGame.getDeveloper() == null) {
            updatedGame.setDeveloper(game.getDeveloper());
        }
        if (updatedGame.getGenres() == null) {
            updatedGame.setGenres(game.getGenres());
        }
        gameRepository.save(updatedGame);
    }

    @Override
    public AfterCreationGameDto createGame(CreateGameDto createGameDto) {
        Game game = gameRepository.findGameByName(createGameDto.getName());
        if (game != null) {
            throw new GameAlreadyExistException(ErrorMessage.THIS_GAME_ALREADY_EXIST);
        }
        if (createGameDto.getId() == null) {
            createGameDto.setId(UUID.randomUUID());
        }
        Game entity = gameMapper.toEntity(createGameDto);
        Game afterCreation = gameRepository.save(entity);
        return gameMapper.toDto(afterCreation);
    }


}
