package com.talataa.test.web.controllers;

import com.talataa.test.domain.dto.MovieDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<GlobalResponseDto<List<MovieDto>>> getAllMovies(@RequestParam @Nullable String page, @RequestParam @Nullable String size) {
        return movieService.getAllMovies(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalResponseDto<MovieDto>> getMovieById(@PathVariable String id) throws ElementNotFound {
        return movieService.getMovieById(id);
    }

    @PostMapping
    public ResponseEntity<GlobalResponseDto<MovieDto>> createMovie(@RequestBody MovieDto movieDto) {
        return movieService.createMovie(movieDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalResponseDto<MovieDto>> updateMovieById(@PathVariable String id, @RequestBody MovieDto movieDto) throws ElementNotFound {
        return movieService.updateMovieById(id, movieDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalResponseDto<Object>> deleteMovieById(@PathVariable String id) throws ElementNotFound {
        return movieService.deleteMovieById(id);
    }
}
