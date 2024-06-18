package org.example.gamemarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class CreateDeveloperDto {

    private String name;

    private LocalDate creationDate;

}
