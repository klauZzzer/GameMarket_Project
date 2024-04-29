package org.example.gamemarket.mapper;

import org.example.gamemarket.dto.AfterCreationGameDto;
import org.example.gamemarket.dto.CreateGameDto;
import org.example.gamemarket.entity.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GameMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "developer", source = "developer")
    @Mapping(target = "genres", source = "genres")
    Game toEntity(CreateGameDto createGameDto);

    @Mapping(target = "overallRating", source = "overallRating")
    @Mapping(target = "sales", source = "sales")
    @Mapping(target = "reviews", source = "reviews")
    AfterCreationGameDto toDto(Game afterCreationGame);

}
