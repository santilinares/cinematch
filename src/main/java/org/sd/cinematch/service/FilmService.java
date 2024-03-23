package org.sd.cinematch.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Collection;
import org.sd.cinematch.model.Film;
import org.springframework.stereotype.Service;

@Service
public class FilmService {
    private ConcurrentMap<Long, Film> films = new ConcurrentHashMap<>();
    private AtomicLong nextId = new AtomicLong(1);

    public FilmService(){}

    public Collection<Film> findAll(){
        return films.values();
    }

    public Film findById(long id){
        return films.get(id);
    }

    public void save(Film film) {
        if(film.getId() == null || film.getId() == 0) {
            long id = nextId.getAndIncrement();
            film.setId(id);            
        }

        this.films.put(film.getId(), film);
    }

    public void deleteById(long id){
        this.films.remove(id);
    }
}
