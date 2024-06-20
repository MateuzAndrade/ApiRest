package com.pegmatita.ApiRest.controller.music;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pegmatita.ApiRest.model.music.Music;
import com.pegmatita.ApiRest.repository.music.MusicRepository;
import com.pegmatita.ApiRest.service.music.MusicService;

@RestController
@RequestMapping("/music")
public class MusicController {
    
    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private MusicService musicService;

    @GetMapping("/list")
    public List<Music> listMusic(){
        return musicRepository.findAll();
    }

    @PostMapping("/create")
    public Music createMusic(@RequestBody Music music) {
        return musicService.createMusic(music);
    }
    
}
