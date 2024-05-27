package org.example.gamemarket.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.example.gamemarket.entity.Developer;
import org.example.gamemarket.entity.Genre;
import org.example.gamemarket.entity.Review;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class CreateGameDto {

    private String name;

    private BigDecimal price;

    private Developer developer;

    private Set<Genre> genres;

}
