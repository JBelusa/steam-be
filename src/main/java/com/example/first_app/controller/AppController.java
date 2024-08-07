package com.example.first_app.controller;


import com.example.first_app.modelDTO.DeveloperDTO;
import com.example.first_app.modelDTO.GameDTO;
import com.example.first_app.service.DeveloperService;
import com.example.first_app.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * This class is a REST controller for the application. It handles HTTP requests and responses for game and developer data.
 * It uses Spring MVC annotations to map HTTP requests to specific methods.
 *
 * @RestController
 * @CrossOrigin
 */
@RestController
@CrossOrigin
public class AppController {

    /**
     * Autowired instances of GameService and DeveloperService for accessing game data.
     */
    @Autowired
    GameService gameService;

    @Autowired
    DeveloperService developerService;

    /**
     * Retrieves a list of all games.
     *
     * @return A list of GameDTO objects representing all games.
     */
    @GetMapping("/games")
    public List<GameDTO> getGames() {
        System.out.println(gameService.getGames());
        return gameService.getGames();
    }

    /**
     * Searches for games based on the provided parameters.
     *
     * @param title       The title of the game.
     * @param price       The price of the game.
     * @param releaseDate The release date of the game.
     * @param developerId The ID of the developer.
     * @return A list of GameDTO objects that match the search criteria.
     */
    @GetMapping("/games/search")
    public List<GameDTO> searchGames(@RequestParam(required = false) String title,
                                     @RequestParam(required = false) BigDecimal price,
                                     @RequestParam(required = false) LocalDate releaseDate,
                                     @RequestParam(required = false) Long developerId) {
        return gameService.searchGames(title, price, releaseDate, developerId);
    }

    /**
     * Retrieves games developed by a specific developer.
     *
     * @param Id The ID of the developer.
     * @return A list of GameDTO objects developed by the specified developer.
     */
    @GetMapping("/gamesByDeveloper/{Id}")
    public List<GameDTO> getGameByDeveloperId(@PathVariable Long Id) {
        return gameService.getGameByDeveloperId(Id);
    }

    /**
     * Retrieves a game by its ID.
     *
     * @param Id The ID of the game.
     * @return A GameDTO object representing the game with the specified ID.
     */
    @GetMapping("/games/{Id}")
    public GameDTO getGameById(@PathVariable Long Id) {
        return gameService.getGameById(Id);
    }

    /**
     * Adds a new game to the database.
     *
     * @param gameDTO The GameDTO object representing the new game.
     * @return The GameDTO object representing the newly added game.
     */
    @PostMapping("/games")
    public GameDTO addGame(@RequestBody GameDTO gameDTO) {
        return gameService.addGame(gameDTO);
    }

    /**
     * Updates an existing game in the database.
     *
     * @param Id      The ID of the game to update.
     * @param gameDTO The updated GameDTO object.
     * @return The updated GameDTO object.
     */
    @PutMapping("/games/{Id}")
    public GameDTO updateGame(@PathVariable Long Id, @RequestBody GameDTO gameDTO) {
        return gameService.updateGame(Id, gameDTO);
    }

    /**
     * Deletes a game from the database.
     *
     * @param Id The ID of the game to delete.
     * @return The deleted GameDTO object.
     */
    @DeleteMapping("/games/{Id}")
    public GameDTO deleteGame(@PathVariable Long Id) {
        return gameService.deleteGame(Id);
    }

    /**
     * Retrieves a list of all developers.
     *
     * @return A list of DeveloperDTO objects representing all developers.
     */
    @GetMapping("/developers")
    public List<DeveloperDTO> getDevelopers() {
        System.out.println(developerService.getDevelopers());
        return developerService.getDevelopers();
    }

    /**
     * Retrieves a developer by their ID.
     *
     * @param Id The ID of the developer.
     * @return A DeveloperDTO object representing the developer with the specified ID.
     */
    @GetMapping("/developers/{Id}")
    public DeveloperDTO getDeveloperByID(@PathVariable Long Id) {
        return developerService.getDeveloperById(Id);
    }

    /**
     * Adds a new developer to the database.
     *
     * @param developerDTO The DeveloperDTO object representing the new developer.
     * @return The DeveloperDTO object representing the newly added developer.
     */
    @PostMapping("/developers")
    public DeveloperDTO addDeveloper(@RequestBody DeveloperDTO developerDTO) {
        return developerService.addDeveloper(developerDTO);
    }

    /**
     * Updates an existing developer in the database.
     *
     * @param Id           The ID of the developer to update. This ID is obtained from the URL path variable.
     * @param developerDTO The updated DeveloperDTO object. This object contains the new data for the developer.
     * @return The updated DeveloperDTO object. This object represents the developer with the updated information.
     * @throws IllegalArgumentException If the provided ID does not match any existing developer in the database.
     * @throws NullPointerException     If the provided developerDTO is null.
     */
    @PutMapping("/developers/{Id}")
    public DeveloperDTO updateDeveloper(@PathVariable Long Id, @RequestBody DeveloperDTO developerDTO) {
        return developerService.updateDeveloper(Id, developerDTO);
    }

    /**
     * Deletes a developer from the database.
     *
     * @param Id The ID of the developer to delete.
     * @return The deleted DeveloperDTO object.
     */
    @DeleteMapping("/developers/{Id}")
    public DeveloperDTO deleteDeveloper(@PathVariable Long Id) {
        return developerService.deleteDeveloperById(Id);

    }
}
