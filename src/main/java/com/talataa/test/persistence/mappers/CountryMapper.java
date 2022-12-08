package com.talataa.test.persistence.mappers;

import com.talataa.test.domain.dto.CountryDto;
import com.talataa.test.persistence.entities.CountryEntity;

import java.util.List;

public interface CountryMapper {

    CountryEntity toCountryEntity(CountryDto countryDto);

    List<CountryEntity> toCountryEntities(List<CountryDto> countryDtos);

    CountryDto toCountryDto(CountryEntity countryEntity);

    List<CountryDto> toCountryDtos(List<CountryEntity> countryEntities);
}
