package com.pegmatita.ApiRest.repository.music;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pegmatita.ApiRest.model.music.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long>{

}
