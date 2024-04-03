package org.sd.cinematch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sd.cinematch.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long>{
    
}
