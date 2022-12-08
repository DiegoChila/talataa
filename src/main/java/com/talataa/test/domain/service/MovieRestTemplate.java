package com.talataa.test.domain.service;

import com.talataa.test.domain.dto.MovieDto;
import com.talataa.test.domain.dto.movie_service.MoviePopularResponseDto;
import org.springframework.http.ResponseEntity;

public interface MovieRestTemplate {

    ResponseEntity<MoviePopularResponseDto> getPopularMovies(String page);

    ResponseEntity<MovieDto> getMovieDetail(String id);
}
