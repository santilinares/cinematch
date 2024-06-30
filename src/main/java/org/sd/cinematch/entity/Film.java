package org.sd.cinematch.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "Film")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "film"
)
public class Film {

    @Id
    @SequenceGenerator(
            name = "film_sequence",
            sequenceName = "film_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "film_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "title",
            updatable = false,
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String title;

    @Column(
            name = "genre",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String genre;

    @Column(
            name = "synopsis",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String synopsis;

    @Column(name = "recommended_age")
    private int recommendedAge;

    @Column(
            name = "actors",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String actors;

    @Column(
            name = "director",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String director;

    @Column(name = "duration")
    private int duration;

    @Column(name = "year")
    private int year;

    @Column(
            name = "trailer",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String trailer;

    @Column(
            name = "cover",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String cover;


   @ManyToOne
    private Platform platform;

    @Getter
    @Setter
    @Transient
    private String platformName;

    @ManyToMany(mappedBy = "addedFilms")
    @JsonIgnore
    private List<User> users;

    public Film(String title, int duration, int year, String synopsis) {
        super();
        this.title = title;
        this.duration = duration;
        this.year = year;
        this.synopsis = synopsis;
    }

    public Film(String title, int duration, int year, String synopsis, String genre, String actors, String director,
                int recommendedAge, String trailer, String cover) {
        super();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setRecommendedAge(int recommendedAge) {
        this.recommendedAge = recommendedAge;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }



    @Override
    public String toString() {
        return "Film [id=" + id + ", title=" + title + ", genre=" + genre + ", synopsis=" + synopsis
                + ", recommendedAge=" + recommendedAge + ", actors=" + actors + ", director=" + director + ", duration="
                + duration + ", year=" + year + ", trailer=" + trailer + ", cover=" + cover + ", platform=" + platform
                + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Film other = (Film) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


}