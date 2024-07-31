package com.example.first_app.repository;

import com.example.first_app.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Repository
public interface GameRepo extends JpaRepository<Game, Long> {
    List<Game> findByDeveloperId(Long id);

    @Query("SELECT g FROM Game g WHERE" +
            " (:title is null or g.title LIKE %:title%) AND" +
            " (:price is null or g.price=:price) AND " +
            " (:releaseDate is null or g.releaseDate=:releaseDate) AND" +
            " (:developerId is null or g.developer.id=:developerId)")
    List<Game> searchGames(@Param("title") String title, @Param("price") BigDecimal price, @Param("releaseDate") LocalDate releaseDate, @Param("developerId") Long developerId);
}
