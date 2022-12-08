package com.talataa.test.domain.service;

import com.talataa.test.domain.dto.CountryDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CountryService {

    ResponseEntity<GlobalResponseDto<List<CountryDto>>>  getAllCountries(String page, String size);

    ResponseEntity<GlobalResponseDto<CountryDto>> getCountryById(String id) throws ElementNotFound;

    ResponseEntity<GlobalResponseDto<CountryDto>> createCountry(CountryDto countryDto);

    ResponseEntity<GlobalResponseDto<CountryDto>> updateCountryById(String id, CountryDto countryDto) throws ElementNotFound;

    ResponseEntity<GlobalResponseDto<Object>> deleteCountryById(String id) throws ElementNotFound;
}
