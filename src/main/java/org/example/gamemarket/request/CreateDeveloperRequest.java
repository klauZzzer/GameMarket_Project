package org.example.gamemarket.request;

import lombok.Getter;
import lombok.Setter;
import org.example.gamemarket.entity.Game;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class CreateDeveloperRequest {

    private UUID id;

    private String name;

    private LocalDate creationDate;

    private Set<Game> developedGames;
}
