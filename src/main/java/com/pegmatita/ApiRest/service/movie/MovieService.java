package com.pegmatita.ApiRest.service.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pegmatita.ApiRest.model.movie.Actors;
import com.pegmatita.ApiRest.model.movie.Director;
import com.pegmatita.ApiRest.model.movie.Movie;
import com.pegmatita.ApiRest.repository.movie.ActorsRepository;
import com.pegmatita.ApiRest.repository.movie.DirectorRepository;
import com.pegmatita.ApiRest.repository.movie.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private ActorsRepository actorsRepository;

    public List<Movie> listMovies() {
        return movieRepository.findAll();
    }

    public Movie createMovie(Movie movie) {

        try {
            Director director = directorRepository.findByName(movie.getDirector().getName());

            if (director == null) {
                director = directorRepository.save(movie.getDirector());
            } else {
                movie.setDirector(director);
            }

            List<Actors> actors = movie.getActors();
            for (int i = 0; i < actors.size(); i++) {
                Actors actor = actors.get(i);
                Actors existingActor = actorsRepository.findByName(actor.getName());
                if (existingActor == null) {
                    existingActor = actorsRepository.save(actor);
                }
                actors.set(i, existingActor); // Atualiza o ator na lista do filme
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return movieRepository.save(movie);

    }

}
