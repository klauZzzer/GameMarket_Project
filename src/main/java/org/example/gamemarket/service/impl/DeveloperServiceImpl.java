package org.example.gamemarket.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.gamemarket.dto.CreateDeveloperDto;
import org.example.gamemarket.entity.Developer;
import org.example.gamemarket.repository.DeveloperRepository;
import org.example.gamemarket.service.DeveloperService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;

    @Override
    public Developer getDeveloperById(UUID id) {
        return developerRepository.findDeveloperById(id);
    }

    @Override
    @Transactional
    public void deleteDeveloperById(UUID id) {
        developerRepository.deleteDeveloperById(id);
    }

    @Override
    public Developer createDeveloper(CreateDeveloperDto createDeveloperDto) {
        return developerRepository.save(createDeveloperDto);
    }
}
