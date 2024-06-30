package org.sd.cinematch.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity(name = "User")
@Table(
        name = "user",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        }
)
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "VARCHAR(60)"
    )
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

    public void setAddedFilms(List<Film> addedFilms) {
        this.addedFilms = addedFilms;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
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
