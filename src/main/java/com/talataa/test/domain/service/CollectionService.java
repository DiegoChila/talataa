package com.talataa.test.domain.service;

import com.talataa.test.domain.dto.CollectionDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CollectionService {

    ResponseEntity<GlobalResponseDto<List<CollectionDto>>> getAllCollections(String page, String size);

    ResponseEntity<GlobalResponseDto<CollectionDto>> getCollectionById(String id) throws ElementNotFound;

    ResponseEntity<GlobalResponseDto<CollectionDto>> createCollection(CollectionDto collectionDto);

    ResponseEntity<GlobalResponseDto<CollectionDto>> updateCollectionById(String id, CollectionDto collectionDto) throws ElementNotFound;

    ResponseEntity<GlobalResponseDto<Object>> deleteCollectionById(String id) throws ElementNotFound;
}
