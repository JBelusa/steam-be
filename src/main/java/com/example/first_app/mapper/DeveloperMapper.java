package com.example.first_app.mapper;

import com.example.first_app.model.Developer;
import com.example.first_app.modelDTO.DeveloperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;


@Component
public class DeveloperMapper {
    @Autowired
    GameMapper gameMapper;

    public DeveloperDTO fromEntityToDTO(Developer developer) {
        DeveloperDTO developerDTO = new DeveloperDTO();
        developerDTO.setId(developer.getId());
        developerDTO.setName(developer.getName());
        developerDTO.setDescription(developer.getDescription());
        developerDTO.setUrl(developer.getUrl());
        developerDTO.setGames(developer.getGames().stream().map(gameMapper::fromEntityToDTO).toList());
        return developerDTO;
    }

//    public Developer fromDTOToEntityGet(DeveloperDTO developerDTO) {
//        Developer developer = new Developer();
//        developer.setName(developerDTO.getName());
//        developer.setDescription(developerDTO.getDescription());
//        developer.setUrl(developerDTO.getUrl());
//        developer.setGames(developerDTO.getGames().stream().map(gameDTO -> gameMapper.fromDTOToEntity(gameDTO, developer)).toList());
//        return developer;
//    }

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

