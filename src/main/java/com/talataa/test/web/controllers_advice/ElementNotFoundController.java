package com.talataa.test.web.controllers_advice;

import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ElementNotFoundController {

    @ExceptionHandler(ElementNotFound.class)
    public ResponseEntity<GlobalResponseDto<Object>> handleCityNotFoundException(ElementNotFound e) {
        return new ResponseEntity<>(new GlobalResponseDto<>(List.of("Elemento no encontrado"), null), HttpStatus.NOT_FOUND);
    }
}
