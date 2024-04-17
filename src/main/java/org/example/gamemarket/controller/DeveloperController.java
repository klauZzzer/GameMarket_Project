package org.example.gamemarket.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.gamemarket.entity.Developer;
import org.example.gamemarket.dto.CreateDeveloperDto;
import org.example.gamemarket.service.DeveloperService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/developer")
@RequiredArgsConstructor
public class DeveloperController {

    private final DeveloperService developerService;

    @GetMapping("/get/{id}")
    public Developer getDeveloperById(@PathVariable("id") UUID id) {
        return developerService.getDeveloperById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void deleteDeveloper(@PathVariable("id") UUID id) {
        developerService.deleteDeveloperById(id);
    }

    @PostMapping("/createDeveloper")
    public Developer createGame(@RequestBody CreateDeveloperDto createDeveloperDto) {
        return developerService.createDeveloper(createDeveloperDto);
    }
}
