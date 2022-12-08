package com.talataa.test.web.controllers;

import com.talataa.test.domain.dto.GenreDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public ResponseEntity<GlobalResponseDto<List<GenreDto>>> getAllGenres(@RequestParam @Nullable String page, @RequestParam @Nullable String size) {
        return genreService.getAllGenres(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalResponseDto<GenreDto>> getGenreById(@PathVariable String id) throws ElementNotFound {
        return genreService.getGenreById(id);
    }

    @PostMapping
    public ResponseEntity<GlobalResponseDto<GenreDto>> createGenre(@RequestBody GenreDto genreDto) {
        return genreService.createGenre(genreDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalResponseDto<GenreDto>> updateGenreById(@PathVariable String id, @RequestBody GenreDto genreDto) throws ElementNotFound {
        return genreService.updateGenreById(id, genreDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalResponseDto<Object>> deleteGenreById(@PathVariable String id) throws ElementNotFound {
        return genreService.deleteGenreById(id);
    }
}
