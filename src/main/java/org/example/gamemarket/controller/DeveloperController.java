package org.example.gamemarket.controller;


import lombok.RequiredArgsConstructor;
import org.example.gamemarket.dto.AfterCreationDeveloperDto;
import org.example.gamemarket.dto.CreateDeveloperDto;
import org.example.gamemarket.entity.Developer;
import org.example.gamemarket.service.DeveloperService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/developer")
@RequiredArgsConstructor
public class DeveloperController {

    private final DeveloperService developerService;

    @GetMapping("/get/id/{id}")
    public Developer getDeveloperById(@PathVariable("id") UUID id) {
        return developerService.getDeveloperById(id);
    }

    @GetMapping("/get/name/{name}")
    public Developer getDeveloperByName(@PathVariable("name") String name) {
        return developerService.getDeveloperByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDeveloperById(@PathVariable("id") UUID id) {
        developerService.deleteDeveloperById(id);
    }

    @PostMapping("/update/{id}")
    public void updateDeveloperById(@PathVariable("id") UUID id, @RequestBody Developer updatedDeveloper) {
        developerService.updateDeveloperById(id, updatedDeveloper);
    }

    @PostMapping("/create")
    public AfterCreationDeveloperDto createDeveloper(@RequestBody CreateDeveloperDto createDeveloperDto) {
        return developerService.createDeveloper(createDeveloperDto);
    }

}
