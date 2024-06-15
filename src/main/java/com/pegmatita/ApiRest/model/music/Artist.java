package com.pegmatita.ApiRest.model.music;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Artist")
public class Artist {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @OneToMany(mappedBy="artist")
    private List<Disc> discs;

    @OneToMany(mappedBy="artist")
    private List<Music> musics;

}
