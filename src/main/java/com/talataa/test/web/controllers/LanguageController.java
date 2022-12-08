package com.talataa.test.web.controllers;

import com.talataa.test.domain.dto.LanguageDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping
    public ResponseEntity<GlobalResponseDto<List<LanguageDto>>> getAllLanguages(@RequestParam @Nullable String page, @RequestParam @Nullable String size) {
        return languageService.getAllLanguages(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalResponseDto<LanguageDto>> getLanguageById(@PathVariable String id) throws ElementNotFound {
        return languageService.getLanguageById(id);
    }

    @PostMapping
    public ResponseEntity<GlobalResponseDto<LanguageDto>> createLanguage(@RequestBody LanguageDto languageDto) {
        return languageService.createLanguage(languageDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalResponseDto<LanguageDto>> updateLanguageById(@PathVariable String id, @RequestBody LanguageDto languageDto) throws ElementNotFound {
        return languageService.updateLanguageById(id, languageDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalResponseDto<Object>> deleteLanguageById(@PathVariable String id) throws ElementNotFound {
        return languageService.deleteLanguageById(id);
    }
}
