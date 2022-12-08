package com.talataa.test.domain.service.impl;

import com.talataa.test.domain.dto.MovieDto;
import com.talataa.test.domain.dto.movie_service.MoviePopularResponseDto;
import com.talataa.test.domain.service.MovieRestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieRestTemplateImpl implements MovieRestTemplate {

    @Value("${rest_template.movies.token}")
    private String token;

    @Value("${rest_template.movies.popular.url}")
    private String urlPopularMovies;

    @Value("${rest_template.movies.detail.url}")
    private String urlMovieDetail;

    @Override
    public ResponseEntity<MoviePopularResponseDto> getPopularMovies(String page) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(getUrlPopularMovies(page), MoviePopularResponseDto.class);
    }

    @Override
    public ResponseEntity<MovieDto> getMovieDetail(String id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(getUrlMovieDetail(id), MovieDto.class);
    }

    private String getUrlPopularMovies(String page) {
        return urlPopularMovies.replace(":token:", token).replace(":page:", page);
    }

    private String getUrlMovieDetail(String id) {
        return urlMovieDetail.replace(":token:", token).replace(":id:", id);
    }
}
