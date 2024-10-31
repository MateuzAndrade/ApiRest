package com.pegmatita.ApiRest.service.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pegmatita.ApiRest.model.music.Artist;
import com.pegmatita.ApiRest.model.music.Disc;
import com.pegmatita.ApiRest.model.music.Music;
import com.pegmatita.ApiRest.repository.music.ArtistRepository;
import com.pegmatita.ApiRest.repository.music.DiscRepository;
import com.pegmatita.ApiRest.repository.music.MusicRepository;

import jakarta.transaction.Transactional;

@Service
public class MusicService {

    @Autowired
    public MusicRepository musicRepository;

    @Autowired
    public DiscRepository discRepository;

    @Autowired
    public ArtistRepository artistRepository;

    @Transactional
    public Music createMusic(Music music) {
        try {
            Disc disc = music.getDisc();
            if (disc != null && disc.getId() == null) {
                discRepository.save(disc);
            }

            Artist artist = music.getArtist();
            if (artist != null && artist.getId() == null) {
                artistRepository.save(artist);
            }

            return musicRepository.save(music);


        } catch (Exception e) {
            System.err.println("Erro ao salvar a música: " + e.getMessage());
            return null;
        }
    }

}
