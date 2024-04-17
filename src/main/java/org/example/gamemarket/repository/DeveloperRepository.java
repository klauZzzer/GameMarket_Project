package org.example.gamemarket.repository;

import org.example.gamemarket.dto.CreateDeveloperDto;
import org.example.gamemarket.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeveloperRepository extends JpaRepository<Developer, UUID> {
    Developer findDeveloperById(UUID id);

    void deleteDeveloperById(UUID id);
    Developer save(CreateDeveloperDto createDeveloperDto);
}
