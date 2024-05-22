package org.example.gamemarket.controller;


import lombok.RequiredArgsConstructor;
import org.example.gamemarket.annotation.UUIDFormatChecker;
import org.example.gamemarket.dto.AfterCreationDeveloperDto;
import org.example.gamemarket.dto.CreateDeveloperDto;
import org.example.gamemarket.entity.Developer;
import org.example.gamemarket.service.DeveloperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Validated
@RestController
@RequestMapping("/developer")
@RequiredArgsConstructor
public class DeveloperController {

    private final DeveloperService developerService;

    @GetMapping("/get/id/{id}")
    public ResponseEntity<?> getDeveloperById(@UUIDFormatChecker @PathVariable("id") UUID id) {
        Developer developer = developerService.getDeveloperById(id);
        if (developer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Developer not found");
        }
        return ResponseEntity.ok(developer);
    }

    @GetMapping("/get/name/{name}")
    public ResponseEntity<?> getDeveloperByName(@PathVariable("name") String name) {
        Developer developer = developerService.getDeveloperByName(name);
        if (developer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Developer not found");
        }
        return ResponseEntity.ok(developer);
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
