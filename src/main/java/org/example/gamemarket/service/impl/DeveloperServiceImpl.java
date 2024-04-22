package org.example.gamemarket.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.gamemarket.dto.AfterCreationDeveloperDto;
import org.example.gamemarket.dto.CreateDeveloperDto;
import org.example.gamemarket.entity.Developer;
import org.example.gamemarket.exception.DeveloperAlreadyExistException;
import org.example.gamemarket.exception.DeveloperDoesNotExistException;
import org.example.gamemarket.exception.ErrorMessage;
import org.example.gamemarket.mapper.DeveloperMapper;
import org.example.gamemarket.repository.DeveloperRepository;
import org.example.gamemarket.service.DeveloperService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;
    private final DeveloperMapper developerMapper;

    @Override
    public Developer getDeveloperById(UUID id) {
        return developerRepository.findDeveloperById(id);
    }

    @Override
    public Developer getDeveloperByName(String name) {
        return developerRepository.findDeveloperByName(name);
    }

    @Override
    public void deleteDeveloperById(UUID id) {
        Developer developer = developerRepository.findDeveloperById(id);
        if (developer == null) {
            throw new DeveloperDoesNotExistException(ErrorMessage.THIS_DEVELOPER_DOES_NOT_EXIST);
        }
        developerRepository.deleteById(id);
    }

    @Override
    public AfterCreationDeveloperDto createDeveloper(CreateDeveloperDto createDeveloperDto) {
        Developer developer = developerRepository.findDeveloperByName(createDeveloperDto.getName());
        if (developer != null) {
            throw new DeveloperAlreadyExistException(ErrorMessage.THIS_DEVELOPER_ALREADY_EXIST);
        }
        Developer entity = developerMapper.toEntity(createDeveloperDto);
        Developer afterCreation = developerRepository.save(entity);
        return developerMapper.toDto(afterCreation);
    }

}
