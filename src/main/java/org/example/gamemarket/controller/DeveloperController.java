package org.example.gamemarket.controller;

import lombok.RequiredArgsConstructor;
import org.example.gamemarket.entity.Developer;
import org.example.gamemarket.request.CreateDeveloperRequest;
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

    @PostMapping("/createDeveloper")
    public Developer createGame(@RequestBody CreateDeveloperRequest request) {
        Developer developer = new Developer();
        developer.setId(request.getId());
        developer.setName(request.getName());
        developer.setCreationDate(request.getCreationDate());
        developer.setDevelopedGames(request.getDevelopedGames());
        return developerService.createDeveloper(developer);
    }
}
