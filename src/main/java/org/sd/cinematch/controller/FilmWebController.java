package org.sd.cinematch.controller;

import org.sd.cinematch.entity.Film;
import org.sd.cinematch.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class FilmWebController {

    private final FilmService filmService;

    public FilmWebController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/")
    public String homeFilms(Model model) {
        model.addAttribute("suspense", filmService.findByGenre("Suspense"));
        model.addAttribute("comedy", filmService.findByGenre("Comedy"));
        model.addAttribute("science_fiction", filmService.findByGenre("Science Fiction"));
        model.addAttribute("drama", filmService.findByGenre("Drama"));
        model.addAttribute("documentary", filmService.findByGenre("Documentary"));
        model.addAttribute("action", filmService.findByGenre("Action"));
        model.addAttribute("romance", filmService.findByGenre("Romance"));
        model.addAttribute("horror", filmService.findByGenre("Horror"));
        return "home";
    }

    @GetMapping("/films/{id}")
    public String showFilm(Model model, @PathVariable long id) {

        Film film = filmService.findById(id);
        if (film != null) {
            model.addAttribute("film", film);
            return "film";
        } else
            return "error";
    }

    @GetMapping("/removefilm/{id}")
    public String removeFilm(Model model, @PathVariable long id) {

        Film removedFilm = filmService.findById(id);
        if (removedFilm != null) {
            model.addAttribute("error", false);
            return "home";
        } else
            return "error";
    }

    // Redirecciona a createFilm.html
    @GetMapping("/createfilm")
    public String createFilm() {
        return "createfilm";
    }
    @GetMapping("/deletefilm")
    public String deleteFilm() {
        return "deletefilm";
    }
    @GetMapping("/updatefilm")
    public String updateFilm() {
        return "updatefilm";
    }
    @GetMapping("/replacefilm")
    public String replaceFilm() {
        return "replacefilm";
    }

    @GetMapping("/films")
    public String films() {
        return "films";        
    }

    @GetMapping("/tvseries")
    public String tvSeries() {
        return "series";        
    }
    @GetMapping("/watchlist")
    public String watchlist() {
        return "watchlist";        
    }
    @GetMapping("/search")
    public String search() {
        return "search";        
    }
    //Eliminar
    @GetMapping("/film")
    public String film() {
        return "film";        
    }
    @GetMapping("/manage")
    public String manage() {
        return "manage";        
    }

    
}
