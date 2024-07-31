package com.example.first_app.service;

import com.example.first_app.mapper.GameMapper;
import com.example.first_app.model.Game;
import com.example.first_app.model.Developer;


import com.example.first_app.modelDTO.GameDTO;
import com.example.first_app.repository.DeveloperRepo;
import com.example.first_app.repository.GameRepo;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Service

public class GameService {

    @Autowired
    GameRepo gameRepo;
    @Autowired
    DeveloperRepo developerRepo;
    @Autowired
    GameMapper gameMapper;

    public List<GameDTO> getGames() {
        List<GameDTO> testList = gameRepo.findAll().stream().map(gameMapper::fromEntityToDTO).toList();
        return gameRepo.findAll().stream().map(gameMapper::fromEntityToDTO).toList();
    }

    public GameDTO getGameById(Long Id) {
        return gameMapper.fromEntityToDTO(gameRepo.findById(Id).orElse(new Game()));
    }

    public List<GameDTO> getGameByDeveloperId(Long Id) {
        return gameRepo.findByDeveloperId(Id).stream().map(gameMapper::fromEntityToDTO).toList();
    }

    public List<GameDTO> searchGames(String title, BigDecimal price, LocalDate releaseDate, Long developerId) {
        return gameRepo.searchGames(title, price, releaseDate, developerId).stream().map(gameMapper::fromEntityToDTO).toList();
    }

    public GameDTO addGame(GameDTO gameDTO) {
        Developer developer = developerRepo.findById(gameDTO.getDeveloperId()).orElseThrow(() -> new RuntimeException("Developer not found"));
        Game game = gameMapper.fromDTOToEntity(gameDTO, developer);
        Game savedGame = gameRepo.save(game);
        return gameMapper.fromEntityToDTO(savedGame);
    }

    public GameDTO updateGame(Long Id, GameDTO gameDTO) {
        Game existingGame = gameRepo.findById(Id).orElse(new Game());
        existingGame.setTitle(gameDTO.getTitle());
        existingGame.setPrice(gameDTO.getPrice());
        existingGame.setDescription(gameDTO.getDescription());
        existingGame.setImageUrl(gameDTO.getImageUrl());
        existingGame.setReleaseDate(gameDTO.getReleaseDate());
        Developer developer = developerRepo.findById(gameDTO.getDeveloperId()).orElseThrow(() -> new RuntimeException("Developer not found"));
        existingGame.setDeveloper(developer);
        Game updatedGame = gameRepo.save(existingGame);

        return gameMapper.fromEntityToDTO(updatedGame);
    }

    public GameDTO deleteGame(Long Id) {
        Game deletedGame = gameRepo.findById(Id).orElse(new Game());
        gameRepo.deleteById(Id);
        return gameMapper.fromEntityToDTO(deletedGame);
    }
}
