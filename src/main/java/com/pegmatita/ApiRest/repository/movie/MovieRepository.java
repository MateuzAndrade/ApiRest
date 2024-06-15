package com.pegmatita.ApiRest.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pegmatita.ApiRest.model.movie.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
