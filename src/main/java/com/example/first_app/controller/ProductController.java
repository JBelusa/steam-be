package com.example.first_app.controller;


import com.example.first_app.model.Product;
import com.example.first_app.modelDTO.DeveloperDTO;
import com.example.first_app.modelDTO.GameDTO;
import com.example.first_app.service.DeveloperService;
import com.example.first_app.service.GameService;
import com.example.first_app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
public class ProductController {
    @Autowired
    ProductService service;
    @Autowired
    GameService gameService;

    @Autowired
    DeveloperService developerService;


    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/products/{prodId}")
    public Product getProductByID(@PathVariable int prodId) {
        return service.getProductByID(prodId);
    }


    @PostMapping("/products")

    public void addProduct(@RequestBody Product prod) {
        service.addProduct(prod);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prod) {
        service.updateProduct(prod);
    }

    @DeleteMapping("/products/{prodId}")
    public void deleteProduct(@PathVariable int prodId) {
        service.deleteProduct(prodId);
    }

    @GetMapping("/games")
    public List<GameDTO> getGames() {
        System.out.println(gameService.getGames());
        return gameService.getGames();
    }

    @GetMapping("/games/search")
    public List<GameDTO> searchGames(@RequestParam(required = false) String title,
                                     @RequestParam(required = false) BigDecimal price,
                                     @RequestParam(required = false) LocalDate releaseDate,
                                     @RequestParam(required = false) Long developerId) {
        return gameService.searchGames(title, price, releaseDate, developerId);
    }

    @GetMapping("/gamesByDeveloper/{Id}")
    public List<GameDTO> getGameByDeveloperId(@PathVariable Long Id) {
        return gameService.getGameByDeveloperId(Id);
    }

    @GetMapping("/games/{Id}")
    public GameDTO getGameById(@PathVariable Long Id) {
        return gameService.getGameById(Id);
    }

    @PostMapping("/games")
    public GameDTO addGame(@RequestBody GameDTO gameDTO) {
        return gameService.addGame(gameDTO);

    }

    @PutMapping("/games/{Id}")
    public GameDTO updateGame(@PathVariable Long Id, @RequestBody GameDTO gameDTO) {
        return gameService.updateGame(Id, gameDTO);

    }

    @DeleteMapping("/games/{Id}")
    public GameDTO deleteGame(@PathVariable Long Id) {
        return gameService.deleteGame(Id);

    }

    @GetMapping("/developers")
    public List<DeveloperDTO> getDevelopers() {
        System.out.println(developerService.getDevelopers());
        return developerService.getDevelopers();
    }

    @GetMapping("/developers/{Id}")
    public DeveloperDTO getDeveloperByID(@PathVariable Long Id) {
        return developerService.getDeveloperById(Id);
    }

    @PostMapping("/developers")
    public DeveloperDTO addDeveloper(@RequestBody DeveloperDTO developerDTO) {
        return developerService.addDeveloper(developerDTO);
    }

    @DeleteMapping("/developers/{Id}")
    public DeveloperDTO deleteDeveloper(@PathVariable Long Id) {
        return developerService.deleteDeveloperById(Id);

    }
}
