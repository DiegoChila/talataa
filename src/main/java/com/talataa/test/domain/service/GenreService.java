package com.talataa.test.domain.service;

import com.talataa.test.domain.dto.GenreDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenreService {

    ResponseEntity<GlobalResponseDto<List<GenreDto>>> getAllGenres(String page, String size);

    ResponseEntity<GlobalResponseDto<GenreDto>> getGenreById(String id) throws ElementNotFound;

    ResponseEntity<GlobalResponseDto<GenreDto>> createGenre(GenreDto genreDto);

    ResponseEntity<GlobalResponseDto<GenreDto>> updateGenreById(String id, GenreDto genreDto) throws ElementNotFound;

    ResponseEntity<GlobalResponseDto<Object>> deleteGenreById(String id) throws ElementNotFound;
}
