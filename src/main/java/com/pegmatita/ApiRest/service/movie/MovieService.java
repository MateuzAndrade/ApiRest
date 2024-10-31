package com.pegmatita.ApiRest.service.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pegmatita.ApiRest.model.movie.Movie;
import com.pegmatita.ApiRest.repository.movie.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> listMovies(){
       return movieRepository.findAll();
    }

    public Movie createMovie(Movie movie){
        movieRepository.save(movie);
        return movie;
    }

}
