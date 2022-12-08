package com.talataa.test.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyDto {

    @JsonProperty("id")
    private Long idCompany;

    @JsonProperty("logo_path")
    private String logoPath;

    @JsonProperty("name")
    private String name;

    @JsonProperty("origin_country")
    private String originCountry;

    public CompanyDto() {
    }

    public CompanyDto(Long idCompany, String logoPath, String name, String originCountry) {
        this.idCompany = idCompany;
        this.logoPath = logoPath;
        this.name = name;
        this.originCountry = originCountry;
    }

    public Long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }
}
