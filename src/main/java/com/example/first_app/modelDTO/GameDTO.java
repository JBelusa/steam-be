package com.example.first_app.modelDTO;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

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
