package com.talataa.test.web.controllers;

import com.talataa.test.domain.dto.CollectionDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collections")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @GetMapping
    public ResponseEntity<GlobalResponseDto<List<CollectionDto>>> getAllCollections(@RequestParam @Nullable String page, @RequestParam @Nullable String size) {
        return collectionService.getAllCollections(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalResponseDto<CollectionDto>> getCollectionById(@PathVariable String id) throws ElementNotFound {
        return collectionService.getCollectionById(id);
    }

    @PostMapping
    public ResponseEntity<GlobalResponseDto<CollectionDto>> createCollection(@RequestBody CollectionDto collectionDto) {
        return collectionService.createCollection(collectionDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalResponseDto<CollectionDto>> updateCollectionById(@PathVariable String id, @RequestBody CollectionDto collectionDto) throws ElementNotFound {
        return collectionService.updateCollectionById(id, collectionDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalResponseDto<Object>> deleteCollectionById(@PathVariable String id) throws ElementNotFound {
        return collectionService.deleteCollectionById(id);
    }
}
