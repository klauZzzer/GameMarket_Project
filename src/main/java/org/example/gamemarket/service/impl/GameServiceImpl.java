package org.example.gamemarket.service.impl;
import lombok.RequiredArgsConstructor;
import org.example.gamemarket.dto.AfterCreationGameDto;
import org.example.gamemarket.dto.CreateGameDto;
import org.example.gamemarket.entity.Game;
import org.example.gamemarket.exception.*;
import org.example.gamemarket.mapper.GameMapper;
import org.example.gamemarket.repository.GameRepository;
import org.example.gamemarket.service.interfaces.GameService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    @Override
    @Transactional
    public Game getGameById(UUID id) {
        Game game = gameRepository.findGameById(id);
        if (game == null) {
            throw new GameDoesNotExistException(ErrorMessage.THIS_GAME_DOES_NOT_EXIST);
        }
        return game;
    }

    @Override
    @Transactional
    public Game getGameByName(String name) {
        Game game = gameRepository.findGameByName(name);
        if (game == null) {
            throw new GameDoesNotExistException(ErrorMessage.THIS_GAME_DOES_NOT_EXIST);
        }
        return game;
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
    @Transactional
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
    @Transactional
    public AfterCreationGameDto createGame(CreateGameDto createGameDto) {
        Game game = gameRepository.findGameByName(createGameDto.getName());
        if (game != null) {
            throw new GameAlreadyExistException(ErrorMessage.THIS_GAME_ALREADY_EXIST);
        }
        Game entity = new Game();
        entity.setId(getID());
        entity = gameMapper.toEntity(createGameDto);
        Game afterCreation = gameRepository.save(entity);
        return gameMapper.toDto(afterCreation);
    }

    @Transactional
    public UUID getID() {
        return UUID.randomUUID();
    }

}
