package com.talataa.test.persistence.mappers;

import com.talataa.test.domain.dto.GenreDto;
import com.talataa.test.domain.dto.LanguageDto;
import com.talataa.test.persistence.entities.GenreEntity;
import com.talataa.test.persistence.entities.LanguageEntity;

import java.util.List;

public interface LanguageMapper {

    LanguageEntity toLanguageEntity(LanguageDto languageDto);

    List<LanguageEntity> toLanguageEntities(List<LanguageDto> languageDtos);

    LanguageDto toLanguageDto(LanguageEntity languageEntity);

    List<LanguageDto> toLanguageDtos(List<LanguageEntity> languageEntities);
}
