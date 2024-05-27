package org.example.gamemarket.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.gamemarket.entity.Game;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class CreateDeveloperDto {

    private String name;

    private LocalDate creationDate;

}
