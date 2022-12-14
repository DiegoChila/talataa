package com.talataa.test.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class GenreEntity {

    @Id
    @Column(name = "id")
    private Long idGenre;

    @Column(name = "name")
    private String name;

    public GenreEntity() {
    }

    public GenreEntity(Long idGenre, String name) {
        this.idGenre = idGenre;
        this.name = name;
    }

    public Long getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Long idGenre) {
        this.idGenre = idGenre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
