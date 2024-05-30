package org.sd.cinematch.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "db-user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    /* Un usuario puede añadir varias peliculas */
    @ManyToMany
    @JoinTable(name = "user_film", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "film_id"))
    private List<Film> addedFilms;

    public User() {
    }

    public User(String name, String email, String password) {

        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public List<Film> getAddedFilms() {
        return addedFilms;
    }

    public void setAddedFilms(List<Film> addedFilms) {
        this.addedFilms = addedFilms;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", addedFilms="
                + addedFilms + "]";
    }

    

}
