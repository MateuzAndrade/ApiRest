package com.pegmatita.ApiRest.model.movie;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name= "actors")
public class Actors {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable= false)
    private String name;

    @Column(nullable = false)
    private boolean oscar;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;

}
