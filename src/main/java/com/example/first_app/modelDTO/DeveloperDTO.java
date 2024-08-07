package com.example.first_app.modelDTO;


import lombok.Data;

import java.util.List;

/**
 * This class represents a Developer's data transfer object (DTO). It is used to transfer data between the application and the database.
 *
 */
@Data

public class DeveloperDTO {
    private Long id;
    private String name;
    private String description;
    private String url;
    private List<GameDTO> games;

}
