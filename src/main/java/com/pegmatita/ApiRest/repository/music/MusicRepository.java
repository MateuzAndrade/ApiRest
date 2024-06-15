package com.pegmatita.ApiRest.repository.music;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pegmatita.ApiRest.model.music.Music;
@Repository
public interface MusicRepository extends JpaRepository<Music, Long>{

}
