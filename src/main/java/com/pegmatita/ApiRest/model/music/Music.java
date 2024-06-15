package com.pegmatita.ApiRest.model.music;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "music")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "disc_id", nullable = false)
    private Disc disc;

    @Column(nullable = false)
    private int timeMusic;

}
