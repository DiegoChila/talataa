package com.talataa.test.domain.repository;

import com.talataa.test.domain.dto.CollectionDto;
import com.talataa.test.domain.exceptions.ElementNotFound;

import java.util.List;

public interface CollectionRepository {
    List<CollectionDto> getAll(int page, int size);

    List<CollectionDto> saveAll(List<CollectionDto> collections);

    CollectionDto getById(Long id) throws ElementNotFound;

    CollectionDto update(Long id, CollectionDto collectionDto) throws ElementNotFound;

    CollectionDto create(CollectionDto collectionDto);

    void delete(Long id) throws ElementNotFound;
}
