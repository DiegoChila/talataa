package com.talataa.test.domain.service.impl;

import com.talataa.test.domain.dto.GenreDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.repository.GenreRepository;
import com.talataa.test.domain.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    private Pattern pattern = Pattern.compile("^\\d+$");

    @Override
    public ResponseEntity<GlobalResponseDto<List<GenreDto>>> getAllGenres(String page, String size) {
        int pageInt = 0;
        int sizeInt = 20;
        if (!Objects.isNull(page) && pattern.matcher(page).matches()) {
            pageInt = Integer.parseInt(page);
        }
        if (!Objects.isNull(size) && pattern.matcher(size).matches()) {
            sizeInt = Integer.parseInt(size);
        }
        return new ResponseEntity<>(new GlobalResponseDto<>(null, genreRepository.getAll(pageInt, sizeInt)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<GenreDto>> getGenreById(String id) throws ElementNotFound {
        return new ResponseEntity<>(new GlobalResponseDto<>(null, genreRepository.getById(Long.parseLong(id))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<GenreDto>> createGenre(GenreDto genreDto) {
        return new ResponseEntity<>(new GlobalResponseDto<>(null, genreRepository.create(genreDto)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<GenreDto>> updateGenreById(String id, GenreDto genreDto) throws ElementNotFound {
        return new ResponseEntity<>(new GlobalResponseDto<>(null, genreRepository.update(Long.parseLong(id), genreDto)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<Object>> deleteGenreById(String id) throws ElementNotFound {
        genreRepository.delete(Long.parseLong(id));
        return new ResponseEntity<>(new GlobalResponseDto<>(null, true), HttpStatus.NO_CONTENT);
    }
}
