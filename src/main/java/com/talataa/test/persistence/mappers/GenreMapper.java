package com.talataa.test.persistence.mappers;

import com.talataa.test.domain.dto.CountryDto;
import com.talataa.test.domain.dto.GenreDto;
import com.talataa.test.persistence.entities.CountryEntity;
import com.talataa.test.persistence.entities.GenreEntity;

import java.util.List;

public interface GenreMapper {

    GenreEntity toGenreEntity(GenreDto genreDto);

    List<GenreEntity> toGenreEntities(List<GenreDto> genreDtos);

    GenreDto toGenreDto(GenreEntity genreEntity);

    List<GenreDto> toGenreDtos(List<GenreEntity> genreEntities);
}
