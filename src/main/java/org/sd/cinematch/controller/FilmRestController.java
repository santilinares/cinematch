package org.sd.cinematch.controller;

import java.net.URI;
import java.util.Collection;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import org.sd.cinematch.model.Film;
import org.sd.cinematch.service.FilmService;

@RestController
@RequestMapping("/film")
public class FilmRestController {

    private FilmService films;

    public FilmRestController(FilmService films) {
        this.films = films;
    }

    @GetMapping("/")
    public Collection<Film> getFilms() {
        return films.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilm(@PathVariable long id) {
        Film film = films.findById(id);
        if (film != null) {
            return ResponseEntity.ok(film);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Film> createFilm(@RequestBody Film film) {
        films.save(film);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(film.getId())
                .toUri();
        return ResponseEntity.created(location).body(film);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Film> deleteFilm(@PathVariable long id) {
        Film film = films.findById(id);
        if (film != null) {
            films.deleteById(id);
            return ResponseEntity.ok(film);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> replaceFilm(@PathVariable long id, @RequestBody Film newFilm) {
        Film film = films.findById(id);
        if (film != null) {
            newFilm.setId(id);
            films.save(newFilm);
            return ResponseEntity.ok(film);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}