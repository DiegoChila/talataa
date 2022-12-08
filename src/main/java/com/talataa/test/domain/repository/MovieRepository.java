package com.talataa.test.domain.repository;

import com.talataa.test.domain.dto.MovieDto;
import com.talataa.test.domain.exceptions.ElementNotFound;

import java.util.List;

public interface MovieRepository {

    List<MovieDto> getAll(int page, int size);

    List<MovieDto> saveAll(List<MovieDto> movies);

    MovieDto getById(Long id) throws ElementNotFound;

    MovieDto update(Long id, MovieDto movieDto) throws ElementNotFound;

    MovieDto create(MovieDto movieDto);

    void delete(Long id) throws ElementNotFound;
}
