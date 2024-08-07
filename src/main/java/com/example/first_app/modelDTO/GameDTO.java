package com.example.first_app.modelDTO;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * This class represents a Game Data Transfer Object (DTO). It is used to transfer game data between layers of an application.
 *
 */
@Data
public class GameDTO {
    private Long id;
    private String title;
    private BigDecimal price;
    private String description;
    private String imageUrl;
    private LocalDate releaseDate;
    private Long developerId;
}
