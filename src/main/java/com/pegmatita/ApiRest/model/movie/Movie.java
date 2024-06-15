package com.pegmatita.ApiRest.model.movie;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="movie")
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable= false)
    private String title;

    @Column(nullable = false)
    private Date releaseDate;

    @ManyToOne
    private Director director;

    @ManyToMany
    private List<Actors> actors;

    @Column(nullable = false)
    private int timeMovie;

}
