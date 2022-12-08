package com.talataa.test.domain.repository;

import com.talataa.test.domain.dto.LanguageDto;
import com.talataa.test.domain.exceptions.ElementNotFound;

import java.util.List;

public interface LanguageRepository {

    List<LanguageDto> getAll(int page, int size);

    List<LanguageDto> saveAll(List<LanguageDto> languages);

    LanguageDto getById(String id) throws ElementNotFound;

    LanguageDto update(String id, LanguageDto languageDto) throws ElementNotFound;

    LanguageDto create(LanguageDto languageDto);

    void delete(String id) throws ElementNotFound;
}
