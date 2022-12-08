package com.talataa.test.domain.repository;

import com.talataa.test.domain.dto.GenreDto;
import com.talataa.test.domain.exceptions.ElementNotFound;

import java.util.List;

public interface GenreRepository {

    List<GenreDto> getAll(int page, int size);

    List<GenreDto> saveAll(List<GenreDto> genres);

    GenreDto getById(Long id) throws ElementNotFound;

    GenreDto update(Long id, GenreDto genreDto) throws ElementNotFound;

    GenreDto create(GenreDto genreDto);

    void delete(Long id) throws ElementNotFound;
}
