package org.sd.cinematch.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "db-film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name = "trailers")
    private String trailer;

    @Column(name = "covers")
    private String cover;

    /* Una pelicula solo puede estar contenida en una plataforma */
    @ManyToOne
    @JoinColumn(name = "platform_id", referencedColumnName = "id")
    private Platform platform;

    /* Una película puede ser añadida por varios usuarios */
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

    public String getTrailer(){
        return trailer;
    }

    public void setTrailer(){
        this.trailer = trailer;
    }

    public String getCover(){
        return cover;
    }

    public void setCover(){
        this.cover = cover;
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
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (genre == null) {
            if (other.genre != null)
                return false;
        } else if (!genre.equals(other.genre))
            return false;
        if (synopsis == null) {
            if (other.synopsis != null)
                return false;
        } else if (!synopsis.equals(other.synopsis))
            return false;
        if (recommendedAge != other.recommendedAge)
            return false;
        if (actors == null) {
            if (other.actors != null)
                return false;
        } else if (!actors.equals(other.actors))
            return false;
        if (director == null) {
            if (other.director != null)
                return false;
        } else if (!director.equals(other.director))
            return false;
        if (duration != other.duration)
            return false;
        if (year != other.year)
            return false;
        if (trailer == null) {
            if (other.trailer != null)
                return false;
        } else if (!trailer.equals(other.trailer))
            return false;
        if (cover == null) {
            if (other.cover != null)
                return false;
        } else if (!cover.equals(other.cover))
            return false;
        if (platform == null) {
            if (other.platform != null)
                return false;
        } else if (!platform.equals(other.platform))
            return false;
        if (users == null) {
            if (other.users != null)
                return false;
        } else if (!users.equals(other.users))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((genre == null) ? 0 : genre.hashCode());
        result = prime * result + ((synopsis == null) ? 0 : synopsis.hashCode());
        result = prime * result + recommendedAge;
        result = prime * result + ((actors == null) ? 0 : actors.hashCode());
        result = prime * result + ((director == null) ? 0 : director.hashCode());
        result = prime * result + duration;
        result = prime * result + year;
        result = prime * result + ((trailer == null) ? 0 : trailer.hashCode());
        result = prime * result + ((cover == null) ? 0 : cover.hashCode());
        result = prime * result + ((platform == null) ? 0 : platform.hashCode());
        result = prime * result + ((users == null) ? 0 : users.hashCode());
        return result;
    }
}