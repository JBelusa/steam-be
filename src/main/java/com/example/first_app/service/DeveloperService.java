package com.example.first_app.service;

import com.example.first_app.mapper.DeveloperMapper;
import com.example.first_app.mapper.GameMapper;
import com.example.first_app.model.Developer;

import com.example.first_app.modelDTO.DeveloperDTO;
import com.example.first_app.modelDTO.GameDTO;
import com.example.first_app.repository.DeveloperRepo;

import com.example.first_app.repository.GameRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service

public class DeveloperService {

    @Autowired
    DeveloperRepo developerRepo;

    @Autowired
    DeveloperMapper developerMapper;

    @Autowired
    GameService gameService;

    @Autowired
    GameRepo gameRepo;

    @Autowired
    GameMapper gameMapper;

    public List<DeveloperDTO> getDevelopers() {
        return developerRepo.findAll().stream().map(developerMapper::fromEntityToDTO).toList();
    }

    public DeveloperDTO getDeveloperById(Long Id) {
        return developerMapper.fromEntityToDTO(developerRepo.findById(Id).orElse(new Developer()));
    }

    public DeveloperDTO addDeveloper(DeveloperDTO developerDTO) {
        Developer savedDeveloper = developerRepo.save(developerMapper.fromDTOToEntity(developerDTO));
        return developerMapper.fromEntityToDTO(savedDeveloper);
    }

    public DeveloperDTO updateDeveloper(Long Id, DeveloperDTO developerDTO) {
        Developer existingDeveloper = developerRepo.findById(Id).orElse(new Developer());
        existingDeveloper.setName(developerDTO.getName());
        existingDeveloper.setDescription(developerDTO.getDescription());
        existingDeveloper.setUrl(developerDTO.getUrl());
//        existingDeveloper.setGames(developerDTO.getGames().stream().map(gameDTO -> gameMapper.fromDTOToEntity(gameDTO, existingDeveloper)).toList());
        Developer updatedDeveloper = developerRepo.save(existingDeveloper);
        return developerMapper.fromEntityToDTO(updatedDeveloper);
    }

    public DeveloperDTO deleteDeveloperById(Long Id) {
        Developer deletedDeveloper = developerRepo.findById(Id).orElse(new Developer());
        gameService.getGameByDeveloperId(Id).forEach(game ->
                gameService.deleteGame(game.getId())
        );
        developerRepo.deleteById(Id);
        return developerMapper.fromEntityToDTO(deletedDeveloper);
    }


}



