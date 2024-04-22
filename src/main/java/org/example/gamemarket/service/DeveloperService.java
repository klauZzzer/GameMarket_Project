package org.example.gamemarket.service;

import org.example.gamemarket.dto.AfterCreationDeveloperDto;
import org.example.gamemarket.dto.CreateDeveloperDto;
import org.example.gamemarket.entity.Developer;

import java.util.UUID;

public interface DeveloperService {
    Developer getDeveloperById(UUID id);

    Developer getDeveloperByName(String name);

    void deleteDeveloperById(UUID id);

    AfterCreationDeveloperDto createDeveloper(CreateDeveloperDto createDeveloperDto);
}
