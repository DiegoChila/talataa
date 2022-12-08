package com.talataa.test.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "collections")
public class CollectionEntity {

    @Id
    @Column(name = "id")
    private Long idCollection;

    @Column(name = "name")
    private String name;

    @Column(name = "poster_path")
    private String posterPath;

    @Column(name = "backdrop_path")
    private String backdropPath;

    public CollectionEntity() {
    }

    public CollectionEntity(Long idCollection, String name, String posterPath, String backdropPath) {
        this.idCollection = idCollection;
        this.name = name;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
    }

    public Long getIdCollection() {
        return idCollection;
    }

    public void setIdCollection(Long idCollection) {
        this.idCollection = idCollection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }
}
