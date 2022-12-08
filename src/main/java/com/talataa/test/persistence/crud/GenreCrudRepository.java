package com.talataa.test.persistence.crud;

import com.talataa.test.persistence.entities.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GenreCrudRepository extends JpaRepository<GenreEntity, Long> {

    @Query(value = "select max(id) from CompanyEntity")
    public Optional<Long> getMAxId();
}
