package org.example.gamemarket.service;

import org.example.gamemarket.entity.Developer;
import org.example.gamemarket.request.CreateDeveloperRequest;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface DeveloperService {
    Developer getDeveloperById(UUID id);
    Developer createDeveloper(Developer developer);
}
