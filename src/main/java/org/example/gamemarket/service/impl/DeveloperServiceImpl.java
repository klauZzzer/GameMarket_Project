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
import org.example.gamemarket.service.interfaces.DeveloperService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;
    private final DeveloperMapper developerMapper;
    @Override
    @Transactional
    public Developer getDeveloperById(UUID id) {
        Developer developer = developerRepository.findDeveloperById(id);
        if (developer == null) {
            throw new DeveloperDoesNotExistException(ErrorMessage.THIS_DEVELOPER_DOES_NOT_EXIST);
        }
        return developer;
    }

    @Override
    @Transactional
    public Developer getDeveloperByName(String name) {
        Developer developer = developerRepository.findDeveloperByName(name);
        if (developer == null) {
            throw new DeveloperDoesNotExistException(ErrorMessage.THIS_DEVELOPER_DOES_NOT_EXIST);
        }
        return developer;
    }

    @Override
    @Transactional
    public void deleteDeveloperById(UUID id) {
        Developer developer = developerRepository.findDeveloperById(id);
        if (developer == null) {
            throw new DeveloperDoesNotExistException(ErrorMessage.THIS_DEVELOPER_DOES_NOT_EXIST);
        }
        developerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateDeveloperById(UUID id, Developer updatedDeveloper) {
        Developer developer = developerRepository.findDeveloperById(id);
        if (developer == null) {
            throw new DeveloperDoesNotExistException(ErrorMessage.THIS_DEVELOPER_DOES_NOT_EXIST);
        }
        updatedDeveloper.setId(developer.getId());
        if (updatedDeveloper.getName() == null) {
            updatedDeveloper.setName(developer.getName());
        }
        if (updatedDeveloper.getCreationDate() == null) {
            updatedDeveloper.setCreationDate(developer.getCreationDate());
        }
        if (updatedDeveloper.getDevelopedGames() == null) {
            updatedDeveloper.setDevelopedGames(developer.getDevelopedGames());
        }
        developerRepository.save(updatedDeveloper);
    }

    @Override
    @Transactional
    public AfterCreationDeveloperDto createDeveloper(CreateDeveloperDto createDeveloperDto) {
        Developer developer = developerRepository.findDeveloperByName(createDeveloperDto.getName());
        if (developer != null) {
            throw new DeveloperAlreadyExistException(ErrorMessage.THIS_DEVELOPER_ALREADY_EXIST);
        }
        Developer entity = new Developer();
        entity.setId(getID());
        entity = developerMapper.toEntity(createDeveloperDto);
        Developer afterCreation = developerRepository.save(entity);
        return developerMapper.toDto(afterCreation);
    }

    @Transactional
    public UUID getID() {
        return UUID.randomUUID();
    }

}
