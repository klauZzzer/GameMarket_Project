package org.example.gamemarket.dto;

import org.example.gamemarket.entity.Review;

import java.util.Set;
import java.util.UUID;

public class AfterCreationGameDto {

    private UUID id;

    private double overallRating = 0.0;

    private int sales = 0;

    private Set<Review> reviews = null;


}
