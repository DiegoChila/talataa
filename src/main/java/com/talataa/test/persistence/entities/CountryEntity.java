package com.talataa.test.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class CountryEntity {

    @Id
    @Column(name = "iso_3166_1")
    private String isoValue;

    @Column(name = "name")
    private String name;

    public CountryEntity() {
    }

    public CountryEntity(String isoValue, String name) {
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
