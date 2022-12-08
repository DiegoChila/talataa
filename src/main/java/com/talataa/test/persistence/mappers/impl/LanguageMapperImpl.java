package com.talataa.test.persistence.mappers.impl;

import com.talataa.test.domain.dto.LanguageDto;
import com.talataa.test.persistence.entities.LanguageEntity;
import com.talataa.test.persistence.mappers.LanguageMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LanguageMapperImpl implements LanguageMapper {

    @Override
    public LanguageEntity toLanguageEntity(LanguageDto languageDto) {
        return new LanguageEntity(languageDto.getIsoValue(), languageDto.getName(), languageDto.getEnglishName());
    }

    @Override
    public List<LanguageEntity> toLanguageEntities(List<LanguageDto> languageDtos) {
        return languageDtos.stream().map(this::toLanguageEntity).collect(Collectors.toList());
    }

    @Override
    public LanguageDto toLanguageDto(LanguageEntity languageEntity) {
        return new LanguageDto(languageEntity.getIsoValue(), languageEntity.getName(), languageEntity.getEnglishName());
    }

    @Override
    public List<LanguageDto> toLanguageDtos(List<LanguageEntity> languageEntities) {
        return languageEntities.stream().map(this::toLanguageDto).collect(Collectors.toList());
    }
}
