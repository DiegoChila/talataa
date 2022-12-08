package com.talataa.test.web.controllers;

import com.talataa.test.domain.dto.CompanyDto;
import com.talataa.test.domain.dto.CountryDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.service.CountryService;
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
    public ResponseEntity<GlobalResponseDto<List<CountryDto>>> getAllCountries(@RequestParam @Nullable String page, @RequestParam @Nullable String size) {
        return countryService.getAllCountries(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalResponseDto<CountryDto>> getCountryById(@PathVariable String id) throws ElementNotFound {
        return countryService.getCountryById(id);
    }

    @PostMapping
    public ResponseEntity<GlobalResponseDto<CountryDto>> createCountry(@RequestBody CountryDto countryDto) {
        return countryService.createCountry(countryDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalResponseDto<CountryDto>> updateCountryById(@PathVariable String id, @RequestBody CountryDto countryDto) throws ElementNotFound {
        return countryService.updateCountryById(id, countryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalResponseDto<Object>> deleteCountryById(@PathVariable String id) throws ElementNotFound {
        return countryService.deleteCountryById(id);
    }
}
