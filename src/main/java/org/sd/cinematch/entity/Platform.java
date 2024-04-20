package org.sd.cinematch.entity;

import java.util.List;

import jakarta.persistence.*;

import org.sd.cinematch.repository.FilmRepository;

@Entity
@Table(name = "platforms")
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id = null;

    @Column(name = "name")
    private String name;

    /* Una plataforma puede contener muchas peliculas */
    @OneToMany(mappedBy = "platform")
    private List<Film> films;

    public Platform() {
    }

    public Platform(String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
