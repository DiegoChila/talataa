package com.talataa.test.persistence.repositories;

import com.talataa.test.domain.dto.CountryDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.repository.CountryRepository;
import com.talataa.test.persistence.crud.CountryCrudRepository;
import com.talataa.test.persistence.entities.CountryEntity;
import com.talataa.test.persistence.mappers.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class CountryRepositoryImpl implements CountryRepository {

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private CountryCrudRepository countryCrudRepository;

    @Override
    public List<CountryDto> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return countryMapper.toCountryDtos(countryCrudRepository.findAll(pageable).getContent());
    }

    @Override
    public List<CountryDto> saveAll(List<CountryDto> countries) {
        return countryMapper.toCountryDtos(countryCrudRepository.saveAll(countryMapper.toCountryEntities(countries)));
    }

    @Override
    public CountryDto getById(String id) throws ElementNotFound {
        Optional<CountryEntity> countryEntity = countryCrudRepository.findById(id);
        return countryEntity.map(entity -> countryMapper.toCountryDto(entity)).orElseThrow(ElementNotFound::new);
    }

    @Override
    public CountryDto update(String id, CountryDto countryDto) throws ElementNotFound {
        CountryDto dto = getById(id);
        if (!Objects.isNull(dto)) {
            CountryEntity countryEntity = countryMapper.toCountryEntity(dto);
            countryEntity.setName(countryDto.getName());

            return countryMapper.toCountryDto(countryCrudRepository.save(countryEntity));
        }

        return null;
    }

    @Override
    public CountryDto create(CountryDto countryDto) {
        return countryMapper.toCountryDto(countryCrudRepository.save(countryMapper.toCountryEntity(countryDto)));
    }

    @Override
    public void delete(String id) throws ElementNotFound {
        CountryDto dto = getById(id);
        if (!Objects.isNull(dto)) {
            CountryEntity countryEntity = countryMapper.toCountryEntity(dto);
            countryCrudRepository.delete(countryEntity);
        }
    }
}
