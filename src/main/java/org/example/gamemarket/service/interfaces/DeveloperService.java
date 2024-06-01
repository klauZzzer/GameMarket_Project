package org.example.gamemarket.service.interfaces;

import org.example.gamemarket.dto.AfterCreationDeveloperDto;
import org.example.gamemarket.dto.CreateDeveloperDto;
import org.example.gamemarket.entity.Developer;

import java.util.UUID;

public interface DeveloperService {
    Developer getDeveloperById(UUID id);

    Developer getDeveloperByName(String name);

    void deleteDeveloperById(UUID id);

    void updateDeveloperById(UUID id, Developer updatedDeveloper);

    AfterCreationDeveloperDto createDeveloper(CreateDeveloperDto createDeveloperDto);
}
