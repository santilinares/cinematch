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

import lombok.AllArgsConstructor;

import org.sd.cinematch.entity.Film;
import org.sd.cinematch.service.FilmService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/film")
public class FilmRestController {

    private final FilmService films;

    @GetMapping("/")
    public Collection<Film> getFilms() {
        return films.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilm(@PathVariable final long id) {
        Film film = films.findById(id);
        if (film != null) {
            return ResponseEntity.ok(film);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Film> createFilm(@RequestBody final Film film) {        
        films.save(film);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(film.getId()).toUri();
        return ResponseEntity.created(location).body(film);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Film> deleteFilm(@PathVariable final long id){
        Film film = films.findById(id);
          if (film != null) {
            films.deleteById(id);
            return ResponseEntity.ok(film);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> replaceFilm(@PathVariable final long id, @RequestBody final Film newFilm) {
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