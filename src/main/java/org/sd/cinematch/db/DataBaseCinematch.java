/*package org.sd.cinematch.db;

import org.sd.cinematch.entity.Film;
import org.sd.cinematch.repository.FilmRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;


@Component
@Profile("local")
public class DataBaseCinematch {

    private final FilmRepository filmRepository;

    public DataBaseCinematch(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @PostConstruct
    public void init() {
        Film film1 = new Film();
        film1.setTitle("Hypnotic");
        film1.setDuration(94);
        film1.setYear(2003);
        film1.setSynopsis("Detective Danny Rourke searches for his missing daughter. While investigating a series of baffling murders, Rourke discovers, with the help of a psychic, a secret government program that could lead him to his daughter.");
        film1.setGenre("Action");
        film1.setActors("Ben Affleck, Alice Braga, William Fichtner");
        film1.setDirector("Robert Rodriguez");
        film1.setRecommendedAge(16);

        filmRepository.save(film1);

        Film film2 = new Film();
        film2.setTitle("Luca");
        film2.setDuration(98);
        film2.setYear(2021);
        film2.setSynopsis("In a beautiful town on the Italian Riviera, Luca and Alberto enjoy the summer while trying to hide their big secret: they are both sea monsters that turn into humans when they are dry.");
        film2.setGenre("Fantasy");
        film2.setActors("Jacob Tremblay, Jack Dylan Grazer, Emma Berman");
        film2.setDirector("Enrico Casarosa");
        film2.setRecommendedAge(0);

        filmRepository.save(film2);

        Film film3 = new Film();
        film3.setTitle("Barbie");
        film3.setDuration(114);
        film3.setYear(2014);
        film3.setSynopsis("After being kicked out of Barbieland for not being a perfect-looking doll, Barbie sets off into the human world to find true happiness.");
        film3.setGenre("Fantasy");
        film3.setActors("Margot Robbie and Ryan Gosling");
        film3.setDirector("Greta Gerwig");
        film3.setRecommendedAge(13);

        filmRepository.save(film3);

        Film film4 = new Film();
        film4.setTitle("Ocho Apellidos Vascos");
        film4.setDuration(99);
        film4.setYear(2023);
        film4.setSynopsis("Rafa, a young man from Andalusia, moves to the Basque Country to win over Amaia, a Basque girl. To earn her father's approval, he must adapt to a new environment and pretend to be Basque.");
        film4.setGenre("Comedy");
        film4.setActors("Clara Lago, Dani Rovira, Carmen Machi, Karra Elejaldeg");
        film4.setDirector("Emilio Martínez-Lázaro");
        film4.setRecommendedAge(0);

        filmRepository.save(film4);

        Film film5 = new Film();
        film5.setTitle("The Gentlemen");
        film5.setDuration(113);
        film5.setYear(2019);
        film5.setSynopsis("Mickey Pearson, an American expat in London, is building a marijuana empire and wants to retire. His decision sets off a series of plots as others fight for his fortune.");
        film5.setGenre("Action");
        film5.setActors("Charlie Hunnam, Michelle Dockery, Matthew McConaughey");
        film5.setDirector("Guy Ritchie");
        film5.setRecommendedAge(16);

        filmRepository.save(film5);

        Film film6 = new Film();
        film6.setTitle("");
        film6.setDuration();
        film6.setYear();
        film6.setSynopsis("");
        film6.setGenre("");
        film6.setActors("");
        film6.setDirector("");
        film6.setRecommendedAge();

        filmRepository.save(film6);

        
        Film film7 = new Film();
        film7.setTitle("");
        film7.setDuration();
        film7.setYear();
        film7.setSynopsis("");
        film7.setGenre("");
        film7.setActors("");
        film7.setDirector("");
        film7.setRecommendedAge();

        filmRepository.save(film7);

        
        Film film8 = new Film();
        film8.setTitle("");
        film8.setDuration();
        film8.setYear();
        film8.setSynopsis("");
        film8.setGenre("");
        film8.setActors("");
        film8.setDirector("");
        film8.setRecommendedAge();

        filmRepository.save(film8);

        
        Film film9 = new Film();
        film9.setTitle("");
        film9.setDuration();
        film9.setYear();
        film9.setSynopsis("");
        film9.setGenre("");
        film9.setActors("");
        film9.setDirector("");
        film9.setRecommendedAge();

        filmRepository.save(film9);

        
        Film film6 = new Film();
        film6.setTitle("");
        film6.setDuration();
        film6.setYear();
        film6.setSynopsis("");
        film6.setGenre("");
        film6.setActors("");
        film6.setDirector("");
        film6.setRecommendedAge();

        filmRepository.save(film6);

        
        Film film6 = new Film();
        film6.setTitle("");
        film6.setDuration();
        film6.setYear();
        film6.setSynopsis("");
        film6.setGenre("");
        film6.setActors("");
        film6.setDirector("");
        film6.setRecommendedAge();

        filmRepository.save(film6);
    }
}
*/
