package com.example.first_app.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "games")
@Table(name = "developer")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String url;
    //    @JsonIgnoreProperties("developer")
    @OneToMany(mappedBy = "developer", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Game> games;
}
