package com.example.first_app.mapper;

import com.example.first_app.model.Developer;
import com.example.first_app.model.Game;
import com.example.first_app.modelDTO.GameDTO;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {
//    public GameDTO fromEntityToDTO(Game game) {
//
//        GameDTO gameDTO = new GameDTO();
//        gameDTO.setTitle(game.getTitle());
//        gameDTO.setPrice(game.getPrice());
//        gameDTO.setDescription(game.getDescription());
//        gameDTO.setReleaseDate(game.getReleaseDate());
//
//        Developer developerDTO = new Developer();
//        developerDTO.setId(game.getDeveloper().getId());
//        gameDTO.setDeveloper(developerDTO);
//        return gameDTO;
//
//    }

    public GameDTO fromEntityToDTO(Game game) {
        GameDTO gameDTO = new GameDTO();
        gameDTO.setId(game.getId());
        gameDTO.setTitle(game.getTitle());
        gameDTO.setPrice(game.getPrice());
        gameDTO.setDescription(game.getDescription());
        gameDTO.setImageUrl(game.getImageUrl());
        gameDTO.setReleaseDate(game.getReleaseDate());
        gameDTO.setDeveloperId(game.getDeveloper().getId());

        return gameDTO;
    }

    public Game fromDTOToEntity(GameDTO gameDTO, Developer developer) {
        Game game = new Game();
        game.setTitle(gameDTO.getTitle());
        game.setPrice(gameDTO.getPrice());
        game.setDescription(gameDTO.getDescription());
        game.setImageUrl(game.getImageUrl());
        game.setReleaseDate(gameDTO.getReleaseDate());
        game.setDeveloper(developer);

        return game;
    }
}
