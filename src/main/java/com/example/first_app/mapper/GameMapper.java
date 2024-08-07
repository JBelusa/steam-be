package com.example.first_app.mapper;

import com.example.first_app.model.Developer;
import com.example.first_app.model.Game;
import com.example.first_app.modelDTO.GameDTO;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {

    /**
     * Converts a Game entity to a GameDTO object.
     *
     * @param game The Game entity to be converted.
     * @return A GameDTO object containing the data from the input Game entity.
     */
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

    /**
     * Converts a GameDTO object to a Game entity, associating it with a given Developer.
     *
     * @param gameDTO The GameDTO object to be converted.
     * @param developer The Developer entity to associate with the resulting Game entity.
     * @return A Game entity containing the data from the input GameDTO object, associated with the given Developer.
     */
    public Game fromDTOToEntity(GameDTO gameDTO, Developer developer) {
        Game game = new Game();
        game.setTitle(gameDTO.getTitle());
        game.setPrice(gameDTO.getPrice());
        game.setDescription(gameDTO.getDescription());
        game.setImageUrl(gameDTO.getImageUrl());
        game.setReleaseDate(gameDTO.getReleaseDate());
        game.setDeveloper(developer);

        return game;
    }
}
