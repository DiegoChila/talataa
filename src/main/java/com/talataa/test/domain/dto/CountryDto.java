package com.talataa.test.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryDto {

    @JsonProperty("iso_3166_1")
    private String isoValue;

    @JsonProperty("name")
    private String name;

    public CountryDto() {
    }

    public CountryDto(String isoValue, String name) {
        this.isoValue = isoValue;
        this.name = name;
    }

    public String getIsoValue() {
        return isoValue;
    }

    public void setIsoValue(String isoValue) {
        this.isoValue = isoValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
