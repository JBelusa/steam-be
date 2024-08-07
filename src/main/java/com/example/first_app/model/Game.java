package com.example.first_app.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The Game entity class representing a game record in the database.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "VARCHAR(2083)")
    private String imageUrl;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate releaseDate;
    @ManyToOne(optional = false)
    @JoinColumn(name = "developer_id")
    private Developer developer;


}
