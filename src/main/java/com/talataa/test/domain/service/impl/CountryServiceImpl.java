package com.talataa.test.domain.service.impl;

import com.talataa.test.domain.dto.CountryDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.repository.CountryRepository;
import com.talataa.test.domain.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    private Pattern pattern = Pattern.compile("^\\d+$");

    @Override
    public ResponseEntity<GlobalResponseDto<List<CountryDto>>> getAllCountries(String page, String size) {
        int pageInt = 0;
        int sizeInt = 20;
        if (!Objects.isNull(page) && pattern.matcher(page).matches()) {
            pageInt = Integer.parseInt(page);
        }
        if (!Objects.isNull(size) && pattern.matcher(size).matches()) {
            sizeInt = Integer.parseInt(size);
        }
        return new ResponseEntity<>(new GlobalResponseDto<>(null, countryRepository.getAll(pageInt, sizeInt)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<CountryDto>> getCountryById(String id) throws ElementNotFound {
        return new ResponseEntity<>(new GlobalResponseDto<>(null, countryRepository.getById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<CountryDto>> createCountry(CountryDto countryDto) {
        return new ResponseEntity<>(new GlobalResponseDto<>(null, countryRepository.create(countryDto)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<CountryDto>> updateCountryById(String id, CountryDto countryDto) throws ElementNotFound {
        return new ResponseEntity<>(new GlobalResponseDto<>(null, countryRepository.update(id, countryDto)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<Object>> deleteCountryById(String id) throws ElementNotFound {
        countryRepository.delete(id);
        return new ResponseEntity<>(new GlobalResponseDto<>(null, true), HttpStatus.NO_CONTENT);
    }
}
