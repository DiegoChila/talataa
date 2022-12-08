package com.talataa.test.domain.service;

import com.talataa.test.domain.dto.MovieDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MovieService {

    ResponseEntity<GlobalResponseDto<List<MovieDto>>> getAllMovies(String page, String size);

    ResponseEntity<GlobalResponseDto<MovieDto>> getMovieById(String id) throws ElementNotFound;

    ResponseEntity<GlobalResponseDto<MovieDto>> createMovie(MovieDto movieDto);

    ResponseEntity<GlobalResponseDto<MovieDto>> updateMovieById(String id, MovieDto movieDto) throws ElementNotFound;

    ResponseEntity<GlobalResponseDto<Object>> deleteMovieById(String id) throws ElementNotFound;
}
