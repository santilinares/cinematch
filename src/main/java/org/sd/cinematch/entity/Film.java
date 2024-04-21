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
 */
    public Film() {
    }

    public Film(String title, int duration, int year, String synopsis) {
        super();
        this.title = title;
        this.duration = duration;
        this.year = year;
        this.synopsis = synopsis;
    }

    public Film(String title, int duration, int year, String synopsis, String genre, String actors, String director,
            int recommendedAge) {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getRecommendedAge() {
        return recommendedAge;
    }

    public void setRecommendedAge(int recommendedAge) {
        this.recommendedAge = recommendedAge;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}