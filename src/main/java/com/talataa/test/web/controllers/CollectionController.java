package com.talataa.test.web.controllers;

import com.talataa.test.domain.dto.CollectionDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.service.CollectionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/collections")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @GetMapping
    @ApiOperation("Get All collections")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok")
    })
    public ResponseEntity<GlobalResponseDto<List<CollectionDto>>> getAllCollections(@RequestParam @Nullable String page, @RequestParam @Nullable String size) {
        return collectionService.getAllCollections(page, size);
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a collection detail")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Element not found")
    })
    public ResponseEntity<GlobalResponseDto<CollectionDto>> getCollectionById(@PathVariable String id) throws ElementNotFound {
        return collectionService.getCollectionById(id);
    }

    @PostMapping
    @ApiOperation("Create a collection")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created")
    })
    public ResponseEntity<GlobalResponseDto<CollectionDto>> createCollection(@RequestBody CollectionDto collectionDto) {
        return collectionService.createCollection(collectionDto);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update a collection")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Element not found")
    })
    public ResponseEntity<GlobalResponseDto<CollectionDto>> updateCollectionById(@PathVariable String id, @RequestBody CollectionDto collectionDto) throws ElementNotFound {
        return collectionService.updateCollectionById(id, collectionDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a collection")
    @ApiResponses({
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Element not found")
    })
    public ResponseEntity<GlobalResponseDto<Object>> deleteCollectionById(@PathVariable String id) throws ElementNotFound {
        return collectionService.deleteCollectionById(id);
    }
}
