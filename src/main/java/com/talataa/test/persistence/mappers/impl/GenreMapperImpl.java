package com.talataa.test.persistence.mappers.impl;

import com.talataa.test.domain.dto.GenreDto;
import com.talataa.test.persistence.entities.GenreEntity;
import com.talataa.test.persistence.mappers.GenreMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenreMapperImpl implements GenreMapper {

    @Override
    public GenreEntity toGenreEntity(GenreDto genreDto) {
        return new GenreEntity(genreDto.getIdGenre(), genreDto.getName());
    }

    @Override
    public List<GenreEntity> toGenreEntities(List<GenreDto> genreDtos) {
        return genreDtos.stream().map(this::toGenreEntity).collect(Collectors.toList());
    }

    @Override
    public GenreDto toGenreDto(GenreEntity genreEntity) {
        return new GenreDto(genreEntity.getIdGenre(), genreEntity.getName());
    }

    @Override
    public List<GenreDto> toGenreDtos(List<GenreEntity> genreEntities) {
        return genreEntities.stream().map(this::toGenreDto).collect(Collectors.toList());
    }
}
