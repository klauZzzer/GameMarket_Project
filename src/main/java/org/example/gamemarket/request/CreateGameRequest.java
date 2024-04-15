package org.example.gamemarket.request;

import lombok.Getter;
import lombok.Setter;
import org.example.gamemarket.entity.Developer;
import org.example.gamemarket.entity.Genre;
import org.example.gamemarket.entity.Review;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class CreateGameRequest {

    private UUID id;

    private String name;

    private double overallRating;

    private BigDecimal price;

    private Developer developer;

    private Set<Genre> genres;

    private Set<Review> reviews;


}
