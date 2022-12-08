package com.talataa.test.domain.service.impl;

import com.talataa.test.domain.dto.LanguageDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.repository.LanguageRepository;
import com.talataa.test.domain.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    private Pattern pattern = Pattern.compile("^\\d+$");

    @Override
    public ResponseEntity<GlobalResponseDto<List<LanguageDto>>> getAllLanguages(String page, String size) {
        int pageInt = 0;
        int sizeInt = 20;
        if (!Objects.isNull(page) && pattern.matcher(page).matches()) {
            pageInt = Integer.parseInt(page);
        }
        if (!Objects.isNull(size) && pattern.matcher(size).matches()) {
            sizeInt = Integer.parseInt(size);
        }
        return new ResponseEntity<>(new GlobalResponseDto<>(null, languageRepository.getAll(pageInt, sizeInt)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<LanguageDto>> getLanguageById(String id) throws ElementNotFound {
        return new ResponseEntity<>(new GlobalResponseDto<>(null, languageRepository.getById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<LanguageDto>> createLanguage(LanguageDto languageDto) {
        return new ResponseEntity<>(new GlobalResponseDto<>(null, languageRepository.create(languageDto)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<LanguageDto>> updateLanguageById(String id, LanguageDto languageDto) throws ElementNotFound {
        return new ResponseEntity<>(new GlobalResponseDto<>(null, languageRepository.update(id, languageDto)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<Object>> deleteLanguageById(String id) throws ElementNotFound {
        languageRepository.delete(id);
        return new ResponseEntity<>(new GlobalResponseDto<>(null, true), HttpStatus.NO_CONTENT);
    }
}
