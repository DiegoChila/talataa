package com.talataa.test.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GlobalResponseDto<T> {

    @JsonProperty("errors")
    private List<String> errors;

    @JsonProperty("response")
    private T response;

    public GlobalResponseDto() {
    }

    public GlobalResponseDto(List<String> errors, T response) {
        this.errors = errors;
        this.response = response;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
