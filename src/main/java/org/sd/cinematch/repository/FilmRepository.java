package org.sd.cinematch.repository;

import java.util.List;

import org.sd.cinematch.entity.Film;
import org.sd.cinematch.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long>{
    Film findByTitle(String title);
    List<Film> findByPlatform(Platform platform);
    List<Film> findByGenre(String genre);
    List<Film> findByYear(int year);
    List<Film> findByActors(String actors);
}

