package com.pegmatita.ApiRest.controller.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pegmatita.ApiRest.model.movie.Movie;
import com.pegmatita.ApiRest.service.movie.MovieService;


@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/list")
    public ResponseEntity<List<Movie>> list(){
        try {
            List<Movie> movies = movieService.listMovies();
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    
    }
    
    

}
