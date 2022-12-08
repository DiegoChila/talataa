package com.talataa.test.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenreDto {

    @JsonProperty("id")
    private Long idGenre;

    @JsonProperty("name")
    private String name;

    public GenreDto() {
    }

    public GenreDto(Long idGenre, String name) {
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
