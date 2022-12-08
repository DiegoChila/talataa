package com.talataa.test.persistence.repositories;

import com.talataa.test.domain.dto.GenreDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.repository.GenreRepository;
import com.talataa.test.persistence.crud.GenreCrudRepository;
import com.talataa.test.persistence.entities.GenreEntity;
import com.talataa.test.persistence.mappers.GenreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class GenreRepositoryImpl implements GenreRepository {

    @Autowired
    private GenreMapper genreMapper;

    @Autowired
    private GenreCrudRepository genreCrudRepository;

    @Override
    public List<GenreDto> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return genreMapper.toGenreDtos(genreCrudRepository.findAll(pageable).getContent());
    }

    @Override
    public List<GenreDto> saveAll(List<GenreDto> genres) {
        return genreMapper.toGenreDtos(genreCrudRepository.saveAll(genreMapper.toGenreEntities(genres)));
    }

    @Override
    public GenreDto getById(Long id) throws ElementNotFound {
        Optional<GenreEntity> genreEntity = genreCrudRepository.findById(id);
        return genreEntity.map(entity -> genreMapper.toGenreDto(entity)).orElseThrow(ElementNotFound::new);
    }

    @Override
    public GenreDto update(Long id, GenreDto genreDto) throws ElementNotFound {
        GenreDto dto = getById(id);
        if (!Objects.isNull(dto)) {
            GenreEntity genreEntity = genreMapper.toGenreEntity(dto);
            genreEntity.setName(genreDto.getName());

            return genreMapper.toGenreDto(genreCrudRepository.save(genreEntity));
        }

        return null;
    }

    @Override
    public GenreDto create(GenreDto genreDto) {
        GenreEntity genreEntity = genreMapper.toGenreEntity(genreDto);
        Optional<Long> maxId = genreCrudRepository.getMAxId();
        if (maxId.isPresent()) {
            genreEntity.setIdGenre(maxId.get() + 1);
        } else {
            genreEntity.setIdGenre(1L);
        }
        return genreMapper.toGenreDto(genreCrudRepository.save(genreEntity));
    }

    @Override
    public void delete(Long id) throws ElementNotFound {
        GenreDto dto = getById(id);
        if (!Objects.isNull(dto)) {
            GenreEntity genreEntity = genreMapper.toGenreEntity(dto);
            genreCrudRepository.delete(genreEntity);
        }
    }
}
