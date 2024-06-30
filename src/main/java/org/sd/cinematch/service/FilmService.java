package org.sd.cinematch.service;

import java.util.Optional;

import java.util.List;

import org.sd.cinematch.entity.Film;
import org.sd.cinematch.entity.Platform;
import org.sd.cinematch.repository.FilmRepository;
import org.sd.cinematch.repository.PlatformRepository;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

    private final FilmRepository filmRepository;
    private final PlatformRepository platformRepository;
    public FilmService(FilmRepository filmRepository, PlatformRepository platformRepository) {
        this.filmRepository = filmRepository;
        this.platformRepository = platformRepository;
    }

    public List<Film> findAll(){
        return filmRepository.findAll();
    }  
    
    public List<Film> findByGenre(String genre){
        return filmRepository.findByGenre(genre);
    }

    public Film findByTitle(String title){
        return filmRepository.findByTitle(title);
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
        if (film.getPlatform() == null){
            String platformName = film.getPlatformName();
            Optional<Platform> platform = platformRepository.findByName(platformName);
            if (platform.isPresent()) {
                film.setPlatform(platform.get());
            } else {
                throw new RuntimeException("Platform not found");
            }
        }

        film.setPlatformName(film.getPlatform().getName());

        filmRepository.save(film);
    }

    public void deleteById(final long id){
        filmRepository.deleteById(id);
    }
}
