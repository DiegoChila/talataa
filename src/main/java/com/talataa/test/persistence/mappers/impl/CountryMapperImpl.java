package com.talataa.test.persistence.mappers.impl;

import com.talataa.test.domain.dto.CountryDto;
import com.talataa.test.persistence.entities.CountryEntity;
import com.talataa.test.persistence.mappers.CountryMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryMapperImpl implements CountryMapper {
    @Override
    public CountryEntity toCountryEntity(CountryDto countryDto) {
        return new CountryEntity(countryDto.getIsoValue(), countryDto.getName());
    }

    @Override
    public List<CountryEntity> toCountryEntities(List<CountryDto> countryDtos) {
        return countryDtos.stream().map(this::toCountryEntity).collect(Collectors.toList());
    }

    @Override
    public CountryDto toCountryDto(CountryEntity countryEntity) {
        return new CountryDto(countryEntity.getIsoValue(), countryEntity.getName());
    }

    @Override
    public List<CountryDto> toCountryDtos(List<CountryEntity> countryEntities) {
        return countryEntities.stream().map(this::toCountryDto).collect(Collectors.toList());
    }
}
