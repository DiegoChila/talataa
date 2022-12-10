package com.talataa.test.domain.service.impl;

import com.talataa.test.domain.dto.CollectionDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.repository.CollectionRepository;
import com.talataa.test.domain.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
public class CollectionServiceImpl implements CollectionService {


    @Autowired
    private CollectionRepository collectionRepository;

    private Pattern pattern = Pattern.compile("^\\d+$");

    @Override
    public ResponseEntity<GlobalResponseDto<List<CollectionDto>>> getAllCollections(String page, String size) {
        int pageInt = 0;
        int sizeInt = 20;
        if (!Objects.isNull(page) && pattern.matcher(page).matches()) {
            pageInt = Integer.parseInt(page);
        }
        if (!Objects.isNull(size) && pattern.matcher(size).matches()) {
            sizeInt = Integer.parseInt(size);
        }
        return new ResponseEntity<>(new GlobalResponseDto<>(null, collectionRepository.getAll(pageInt, sizeInt)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<CollectionDto>> getCollectionById(String id) throws ElementNotFound {
        return new ResponseEntity<>(new GlobalResponseDto<>(null, collectionRepository.getById(Long.parseLong(id))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<CollectionDto>> createCollection(CollectionDto collectionDto) {
        return new ResponseEntity<>(new GlobalResponseDto<>(null, collectionRepository.create(collectionDto)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<CollectionDto>> updateCollectionById(String id, CollectionDto collectionDto) throws ElementNotFound {
        return new ResponseEntity<>(new GlobalResponseDto<>(null, collectionRepository.update(Long.parseLong(id), collectionDto)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<Object>> deleteCollectionById(String id) throws ElementNotFound {
        collectionRepository.delete(Long.parseLong(id));
        return new ResponseEntity<>(new GlobalResponseDto<>(null, true), HttpStatus.NO_CONTENT);
    }
}
