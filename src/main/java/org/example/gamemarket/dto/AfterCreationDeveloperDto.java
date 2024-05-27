package org.example.gamemarket.dto;

import lombok.Data;
import org.example.gamemarket.entity.Game;

import java.util.Set;
import java.util.UUID;

@Data
public class AfterCreationDeveloperDto {

    private UUID id;

    private Set<Game> developedGames = null;

}
