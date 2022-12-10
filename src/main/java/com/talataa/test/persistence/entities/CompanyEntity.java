package com.talataa.test.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
public class CompanyEntity {

    @Id
    @Column(name = "id")
    private Long idCompany;

    @Column(name = "logo_path")
    private String logoPath;

    @Column(name = "name")
    private String name;

    @Column(name = "origin_country")
    private String originCountry;

    public CompanyEntity() {
    }

    public CompanyEntity(Long idCompany, String logoPath, String name, String originCountry) {
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
