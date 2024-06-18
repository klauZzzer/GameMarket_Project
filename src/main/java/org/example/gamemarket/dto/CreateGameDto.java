package org.example.gamemarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.gamemarket.entity.Developer;
import org.example.gamemarket.entity.Genre;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class CreateGameDto {

    private String name;

    private BigDecimal price;

    private Developer developer;

    private Set<Genre> genres;
}
