package com.talataa.test.domain.service.impl;

import com.talataa.test.domain.dto.MovieDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.repository.MovieRepository;
import com.talataa.test.domain.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    private Pattern pattern = Pattern.compile("^\\d+$");

    @Override
    public ResponseEntity<GlobalResponseDto<List<MovieDto>>> getAllMovies(String page, String size) {
        int pageInt = 0;
        int sizeInt = 20;
        if (!Objects.isNull(page) && pattern.matcher(page).matches()) {
            pageInt = Integer.parseInt(page);
        }
        if (!Objects.isNull(size) && pattern.matcher(size).matches()) {
            sizeInt = Integer.parseInt(size);
        }
        return new ResponseEntity<>(new GlobalResponseDto<>(null, movieRepository.getAll(pageInt, sizeInt)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<MovieDto>> getMovieById(String id) throws ElementNotFound {
        return new ResponseEntity<>(new GlobalResponseDto<>(null, movieRepository.getById(Long.parseLong(id))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<MovieDto>> createMovie(MovieDto movieDto) {
        return new ResponseEntity<>(new GlobalResponseDto<>(null, movieRepository.create(movieDto)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<MovieDto>> updateMovieById(String id, MovieDto movieDto) throws ElementNotFound {
        return new ResponseEntity<>(new GlobalResponseDto<>(null, movieRepository.update(Long.parseLong(id), movieDto)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<Object>> deleteMovieById(String id) throws ElementNotFound {
        movieRepository.delete(Long.parseLong(id));
        return new ResponseEntity<>(new GlobalResponseDto<>(null, true), HttpStatus.NO_CONTENT);
    }
}
