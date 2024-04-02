package org.sd.cinematch.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; 
@Entity 
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private ArrayList<Film> films;

    public Platform(){}
    
    public Platform(String name, ArrayList<Film> films) {
        super();
        this.name = name;
        this.films = films;
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


    public List<Film> getFilms() {
        return films;
    }


    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

 
}
