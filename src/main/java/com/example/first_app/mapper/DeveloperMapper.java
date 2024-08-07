package com.example.first_app.mapper;

import com.example.first_app.model.Developer;
import com.example.first_app.modelDTO.DeveloperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

/**
 * This class is responsible for mapping Developer entities to Developer Data Transfer Objects (DTOs) and vice versa.
 */
@Component
public class DeveloperMapper {
    @Autowired
    GameMapper gameMapper;

    /**
     * Maps a Developer entity to a Developer DTO.
     *
     * @param developer The Developer entity to be mapped.
     * @return The Developer DTO representing the input Developer entity.
     */
    public DeveloperDTO fromEntityToDTO(Developer developer) {
        DeveloperDTO developerDTO = new DeveloperDTO();
        developerDTO.setId(developer.getId());
        developerDTO.setName(developer.getName());
        developerDTO.setDescription(developer.getDescription());
        developerDTO.setUrl(developer.getUrl());
        developerDTO.setGames(developer.getGames().stream().map(gameMapper::fromEntityToDTO).toList());
        return developerDTO;
    }

    /**
     * Maps a Developer DTO to a Developer entity.
     *
     * @param developerDTO The Developer DTO to be mapped.
     * @return The Developer entity representing the input Developer DTO.
     */
    public Developer fromDTOToEntity(DeveloperDTO developerDTO) {
        Developer developer = new Developer();
        developer.setName(developerDTO.getName());
        developer.setDescription(developerDTO.getDescription());
        developer.setUrl(developerDTO.getUrl());
        developer.setGames((Optional.ofNullable(developerDTO.getGames())
                .orElseGet(ArrayList::new)
                .stream()
                .map(gameDTO -> gameMapper.fromDTOToEntity(gameDTO, developer))
                .toList()));
        return developer;
    }
}

