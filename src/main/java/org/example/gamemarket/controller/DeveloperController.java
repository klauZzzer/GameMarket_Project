package org.example.gamemarket.controller;


import lombok.RequiredArgsConstructor;
import org.example.gamemarket.annotation.*;
import org.example.gamemarket.dto.AfterCreationDeveloperDto;
import org.example.gamemarket.dto.CreateDeveloperDto;
import org.example.gamemarket.entity.Developer;
import org.example.gamemarket.service.interfaces.DeveloperService;
import org.example.gamemarket.validation.annotation.UUIDFormatChecker;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Validated
@RestController
@RequestMapping("/developer")
@RequiredArgsConstructor
public class DeveloperController {

    private final DeveloperService developerService;

    @GetDeveloperById(path = "/get/id/{id}")
    public Developer getDeveloperById(@UUIDFormatChecker @PathVariable("id") UUID id) {
        return developerService.getDeveloperById(id);
    }

    @GetDeveloperByName(path = "/get/name/{name}")
    public Developer getDeveloperByName(@PathVariable("name") String name) {
        return developerService.getDeveloperByName(name);
    }

    @DeleteDeveloperById(path = "/delete/{id}")
    public void deleteDeveloperById(@UUIDFormatChecker @PathVariable("id") UUID id) {
        developerService.deleteDeveloperById(id);
    }

    @UpdateDeveloperById(path = "/update/{id}")
    public void updateDeveloperById(@UUIDFormatChecker @PathVariable("id") UUID id, @RequestBody Developer updatedDeveloper) {
        developerService.updateDeveloperById(id, updatedDeveloper);
    }

    @CreateDeveloper(path = "/create")
    public AfterCreationDeveloperDto createDeveloper(@RequestBody CreateDeveloperDto createDeveloperDto) {
        return developerService.createDeveloper(createDeveloperDto);
    }

}
