package org.example.gamemarket.dto;

import lombok.Data;
import org.example.gamemarket.entity.Review;

import java.util.Set;
import java.util.UUID;

@Data
public class AfterCreationGameDto {

    private double overallRating = 0.0;

    private int sales = 0;

    private Set<Review> reviews = null;


}
