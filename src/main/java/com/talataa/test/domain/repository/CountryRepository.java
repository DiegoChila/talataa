package com.talataa.test.domain.repository;

import com.talataa.test.domain.dto.CountryDto;
import com.talataa.test.domain.exceptions.ElementNotFound;

import java.util.List;

public interface CountryRepository {

    List<CountryDto> getAll(int page, int size);

    List<CountryDto> saveAll(List<CountryDto> countries);

    CountryDto getById(String id) throws ElementNotFound;

    CountryDto update(String id, CountryDto countryDto) throws ElementNotFound;

    CountryDto create(CountryDto countryDto);

    void delete(String id) throws ElementNotFound;
}
