package com.pegmatita.ApiRest.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pegmatita.ApiRest.model.movie.Actors;

@Repository
public interface ActorsRepository extends JpaRepository<Actors, Long> {

    Actors findByName(String name);

}
