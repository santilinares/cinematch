package org.sd.cinematch.service;

import java.util.Optional;
import java.util.List;

import org.sd.cinematch.entity.Film;
import org.sd.cinematch.repository.FilmRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;

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

    public void save(final Film film) {
        filmRepository.save(film);           
    }

    public void deleteById(final long id){
        filmRepository.deleteById(id);
    }
}
