package org.sd.cinematch.service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

import org.sd.cinematch.entity.Film;
import org.sd.cinematch.repository.FilmRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
public class FilmService {

    private final FilmRepository filmRepository;
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
    private AtomicLong nextId = new AtomicLong(1);

    public List<Film> findAll(){
        return filmRepository.findAll();
    }

    public Film findById(final long id){
        Optional<Film> optionalPlatform = filmRepository.findById(id);
        if (optionalPlatform.isPresent()) {
         return optionalPlatform.get();
        } else {
         throw new RuntimeException("Film not found");
        }
    }

    public void save(Film film) {

        if (film.getId()== null || film.getId() == 0){
            long id = nextId.getAndIncrement();
            film.setId(id);
        }
        filmRepository.save(film);
    }

    public void deleteById(final long id){
        filmRepository.deleteById(id);
    }
}
