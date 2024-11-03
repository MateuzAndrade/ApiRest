package com.pegmatita.ApiRest.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pegmatita.ApiRest.model.movie.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
    Director findByName (String name);
}
