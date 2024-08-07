package com.example.first_app.repository;

import com.example.first_app.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for Game entity. Provides methods for interacting with the database.
 *
 */
@Repository
public interface GameRepo extends JpaRepository<Game, Long> {

    /**
     * Finds all games associated with a specific developer.
     *
     * @param id the id of the developer
     * @return a list of games associated with the developer
     */
    List<Game> findByDeveloperId(Long id);

    /**
     * Searches for games based on provided criteria.
     *
     * @param title the title of the game. If null, all titles will be considered.
     * @param price the price of the game. If null, all prices will be considered.
     * @param releaseDate the release date of the game. If null, all release dates will be considered.
     * @param developerId the id of the developer. If null, all developers will be considered.
     * @return a list of games that match the provided criteria
     */
    @Query("SELECT g FROM Game g WHERE" +
            " (:title is null or g.title LIKE %:title%) AND" +
            " (:price is null or g.price=:price) AND " +
            " (:releaseDate is null or g.releaseDate=:releaseDate) AND" +
            " (:developerId is null or g.developer.id=:developerId)")
    List<Game> searchGames(@Param("title") String title, @Param("price") BigDecimal price, @Param("releaseDate") LocalDate releaseDate, @Param("developerId") Long developerId);
}
