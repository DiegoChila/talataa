package com.talataa.test.persistence.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "languages")
public class LanguageEntity {

    @Id
    @Column(name = "iso_639_1")
    private String isoValue;

    @Column(name = "name")
    private String name;

    @Column(name = "english_name")
    private String englishName;

    public LanguageEntity() {
    }

    public LanguageEntity(String isoValue, String name, String englishName) {
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
