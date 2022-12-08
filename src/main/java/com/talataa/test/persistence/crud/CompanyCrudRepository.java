package com.talataa.test.persistence.crud;

import com.talataa.test.persistence.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CompanyCrudRepository extends JpaRepository<CompanyEntity, Long> {

    @Query(value = "select max(id) from CompanyEntity")
    public Optional<Long> getMAxId();
}
