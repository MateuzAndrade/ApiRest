package com.pegmatita.ApiRest.controller.music;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pegmatita.ApiRest.model.music.Artist;
import com.pegmatita.ApiRest.model.music.Disc;
import com.pegmatita.ApiRest.model.music.Music;
import com.pegmatita.ApiRest.repository.music.ArtistRepository;
import com.pegmatita.ApiRest.repository.music.DiscRepository;
import com.pegmatita.ApiRest.repository.music.MusicRepository;

@RestController
@RequestMapping("/music")
public class MusicController {

    
     @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private DiscRepository discRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/list")
    public List<Music> listMusic(){
        return musicRepository.findAll();
    }

    @PostMapping("/create")
    public Music createMusic(@RequestBody Music music) {
        // Verificar e salvar o Disc se ele ainda não estiver salvo
        Disc disc = music.getDisc();
        if (disc != null && disc.getId() == null) {
            discRepository.save(disc);
        }
        
        // Verificar e salvar o Artist se ele ainda não estiver salvo
        Artist artist = music.getArtist();
        if (artist != null && artist.getId() == null) {
            artistRepository.save(artist);
        }
        
        // Agora salvar a entidade Music
        return musicRepository.save(music);
    }
    
}
