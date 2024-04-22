package org.example.gamemarket.mapper;

import org.example.gamemarket.dto.AfterCreationDeveloperDto;
import org.example.gamemarket.dto.CreateDeveloperDto;
import org.example.gamemarket.entity.Developer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeveloperMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "creationDate", source = "creationDate")
    Developer toEntity(CreateDeveloperDto createDeveloperDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "developedGames", source = "developedGames")
    AfterCreationDeveloperDto toDto(Developer afterCreation);
}
