package com.talataa.test.domain.service;

import com.talataa.test.domain.dto.LanguageDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LanguageService {

    ResponseEntity<GlobalResponseDto<List<LanguageDto>>> getAllLanguages(String page, String size);

    ResponseEntity<GlobalResponseDto<LanguageDto>> getLanguageById(String id) throws ElementNotFound;

    ResponseEntity<GlobalResponseDto<LanguageDto>> createLanguage(LanguageDto languageDto);

    ResponseEntity<GlobalResponseDto<LanguageDto>> updateLanguageById(String id, LanguageDto languageDto) throws ElementNotFound;

    ResponseEntity<GlobalResponseDto<Object>> deleteLanguageById(String id) throws ElementNotFound;
}
