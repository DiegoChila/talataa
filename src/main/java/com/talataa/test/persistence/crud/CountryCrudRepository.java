package com.talataa.test.persistence.crud;

import com.talataa.test.persistence.entities.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryCrudRepository extends JpaRepository<CountryEntity, String> {
}
