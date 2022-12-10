package com.talataa.test.web.controllers;

import com.talataa.test.domain.dto.CompanyDto;
import com.talataa.test.domain.dto.CountryDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.service.CountryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    @ApiOperation("Get all countries")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok")
    })
    public ResponseEntity<GlobalResponseDto<List<CountryDto>>> getAllCountries(@RequestParam @Nullable String page, @RequestParam @Nullable String size) {
        return countryService.getAllCountries(page, size);
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a country detail")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Element not found")
    })
    public ResponseEntity<GlobalResponseDto<CountryDto>> getCountryById(@PathVariable String id) throws ElementNotFound {
        return countryService.getCountryById(id);
    }

    @PostMapping
    @ApiOperation("Create a country")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Create")
    })
    public ResponseEntity<GlobalResponseDto<CountryDto>> createCountry(@RequestBody CountryDto countryDto) {
        return countryService.createCountry(countryDto);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update a country")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Element not found")
    })
    public ResponseEntity<GlobalResponseDto<CountryDto>> updateCountryById(@PathVariable String id, @RequestBody CountryDto countryDto) throws ElementNotFound {
        return countryService.updateCountryById(id, countryDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a country")
    @ApiResponses({
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "Element not found")
    })
    public ResponseEntity<GlobalResponseDto<Object>> deleteCountryById(@PathVariable String id) throws ElementNotFound {
        return countryService.deleteCountryById(id);
    }
}
