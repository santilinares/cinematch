package org.sd.cinematch.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "titles")
    private String title;

    @Column(name = "genres")
    private String genre;

    @Column(name = "synopsis")
    private String synopsis;
    
    @Column(name = "recommended_ages")
    private int recommendedAge;

    @Column(name = "actors")
    private String actors;

    @Column(name = "director")
    private String director;

    @Column(name = "durations")
    private int duration;

    @Column(name = "years")
    private int year;

    /* Una pelicula solo puede estar contenida en una plataforma */
    @ManyToOne
    @JoinColumn(name = "platform_id")
    private Platform platform;

    /* Una película puede ser añadida por varios usuarios */
    @ManyToMany(mappedBy = "addedFilms")
    private List<User> users;
}