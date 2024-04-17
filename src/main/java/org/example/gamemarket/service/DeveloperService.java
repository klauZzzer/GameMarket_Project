package org.example.gamemarket.service;

import org.example.gamemarket.dto.CreateDeveloperDto;
import org.example.gamemarket.entity.Developer;

import java.util.UUID;

public interface DeveloperService {
    Developer getDeveloperById(UUID id);

    void deleteDeveloperById(UUID id);

    Developer createDeveloper(CreateDeveloperDto createDeveloperDto);
}
