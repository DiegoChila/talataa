package com.talataa.test.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LanguageDto {

    @JsonProperty("iso_639_1")
    private String isoValue;

    @JsonProperty("name")
    private String name;

    @JsonProperty("english_name")
    private String englishName;

    public LanguageDto() {
    }

    public LanguageDto(String isoValue, String name, String englishName) {
        this.isoValue = isoValue;
        this.name = name;
        this.englishName = englishName;
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

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }
}
