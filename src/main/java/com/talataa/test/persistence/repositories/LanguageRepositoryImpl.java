package com.talataa.test.persistence.repositories;

import com.talataa.test.domain.dto.LanguageDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.repository.LanguageRepository;
import com.talataa.test.persistence.crud.LanguageCrudRepository;
import com.talataa.test.persistence.entities.LanguageEntity;
import com.talataa.test.persistence.mappers.LanguageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class LanguageRepositoryImpl implements LanguageRepository {

    @Autowired
    private LanguageMapper languageMapper;

    @Autowired
    private LanguageCrudRepository languageCrudRepository;

    @Override
    public List<LanguageDto> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return languageMapper.toLanguageDtos(languageCrudRepository.findAll(pageable).getContent());
    }

    @Override
    public List<LanguageDto> saveAll(List<LanguageDto> languages) {
        return languageMapper.toLanguageDtos(languageCrudRepository.saveAll(languageMapper.toLanguageEntities(languages)));
    }

    @Override
    public LanguageDto getById(String id) throws ElementNotFound {
        Optional<LanguageEntity> languageEntity = languageCrudRepository.findById(id);
        return languageEntity.map(entity -> languageMapper.toLanguageDto(entity)).orElseThrow(ElementNotFound::new);
    }

    @Override
    public LanguageDto update(String id, LanguageDto languageDto) throws ElementNotFound {
        LanguageDto dto = getById(id);
        if (!Objects.isNull(dto)) {
            LanguageEntity languageEntity = languageMapper.toLanguageEntity(dto);
            languageEntity.setEnglishName(languageDto.getEnglishName());
            languageEntity.setName(languageDto.getName());

            return languageMapper.toLanguageDto(languageCrudRepository.save(languageEntity));
        }

        return null;
    }

    @Override
    public LanguageDto create(LanguageDto languageDto) {
        return languageMapper.toLanguageDto(languageCrudRepository.save(languageMapper.toLanguageEntity(languageDto)));
    }

    @Override
    public void delete(String id) throws ElementNotFound {
        LanguageDto dto = getById(id);
        if (!Objects.isNull(dto)) {
            LanguageEntity languageEntity = languageMapper.toLanguageEntity(dto);
            languageCrudRepository.delete(languageEntity);
        }
    }
}
