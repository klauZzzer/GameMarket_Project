package org.example.gamemarket.service.impl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.gamemarket.dto.AfterCreationGameDto;
import org.example.gamemarket.dto.CreateGameDto;
import org.example.gamemarket.entity.Developer;
import org.example.gamemarket.entity.Game;
import org.example.gamemarket.entity.Review;
import org.example.gamemarket.exception.ErrorMessage;
import org.example.gamemarket.exception.GameDoesNotExistException;
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

    @Override
    public Game getGameById(UUID id) {
        return gameRepository.findGameById(id);
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

//    @Override
//    public AfterCreationGameDto createGame(CreateGameDto createGameDto) {
//        Game game = gameRepository.findGameByName(createGameDto.getName());
//        if (game != null) {
//        }
//        UUID developerId = createGameDto.getDeveloper().getId();
//        Developer developer = developerRepository.findDeveloperById(developerId);
//        if (developer == null) {
//        }
//        Game entity = gameMapper.toEntity(createGameDto);
//        Game afterCreationGame = gameRepository.save(entity);
//        return gameMapper.toDto(afterCreationGame);
//    }
}
