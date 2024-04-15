package org.example.gamemarket.repository;

import org.example.gamemarket.entity.Developer;
import org.example.gamemarket.request.CreateDeveloperRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface DeveloperRepository extends JpaRepository<Developer, UUID> {
    Developer findDeveloperById(UUID id);
    Developer save(Developer developer);
}
