package org.sd.cinematch.entity;

import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "plataforma")
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    @Override
    public String toString() {
        return "Platform [id=" + id + ", name=" + name + ", films=" + films + "]";
    }
 
    
}
