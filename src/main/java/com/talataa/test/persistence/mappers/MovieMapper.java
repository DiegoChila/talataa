package com.talataa.test.persistence.mappers;

import com.talataa.test.domain.dto.LanguageDto;
import com.talataa.test.domain.dto.MovieDto;
import com.talataa.test.persistence.entities.LanguageEntity;
import com.talataa.test.persistence.entities.MovieEntity;

import java.util.List;

public interface MovieMapper {

    MovieEntity toMovieEntity(MovieDto movieDto);

    List<MovieEntity> toMovieEntities(List<MovieDto> movieDtos);

    MovieDto toMovieDto(MovieEntity movieEntity);

    List<MovieDto> toMovieDtos(List<MovieEntity> movieEntities);
}
