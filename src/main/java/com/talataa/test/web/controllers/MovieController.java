package com.talataa.test.web.controllers;

import com.talataa.test.domain.dto.MovieDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.service.MovieService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation("Get all movies")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok")
    })
    public ResponseEntity<GlobalResponseDto<List<MovieDto>>> getAllMovies(@RequestParam @Nullable String page, @RequestParam @Nullable String size) {
        return movieService.getAllMovies(page, size);
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a movie detail")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Element not found")
    })
    public ResponseEntity<GlobalResponseDto<MovieDto>> getMovieById(@PathVariable String id) throws ElementNotFound {
        return movieService.getMovieById(id);
    }

    @PostMapping
    @ApiOperation("Create a movie")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created")
    })
    public ResponseEntity<GlobalResponseDto<MovieDto>> createMovie(@RequestBody MovieDto movieDto) {
        return movieService.createMovie(movieDto);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update a movie")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Element not found")
    })
    public ResponseEntity<GlobalResponseDto<MovieDto>> updateMovieById(@PathVariable String id, @RequestBody MovieDto movieDto) throws ElementNotFound {
        return movieService.updateMovieById(id, movieDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a movie")
    @ApiResponses({
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "Element not found")
    })
    public ResponseEntity<GlobalResponseDto<Object>> deleteMovieById(@PathVariable String id) throws ElementNotFound {
        return movieService.deleteMovieById(id);
    }
}
