package com.example.first_app.modelDTO;


import lombok.Data;

import java.util.List;

@Data

public class DeveloperDTO {
    private Long id;
    private String name;
    private String description;
    private String url;
    private List<GameDTO> games;

}
