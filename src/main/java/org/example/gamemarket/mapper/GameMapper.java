package org.example.gamemarket.mapper;

import org.example.gamemarket.dto.AfterCreationGameDto;
import org.example.gamemarket.dto.CreateGameDto;
import org.example.gamemarket.entity.Game;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GameMapper {
//    Game toEntity(CreateGameDto createGameDto);
//
//    AfterCreationGameDto toDto(Game afterCreationGame);
}
