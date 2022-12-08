package com.talataa.test.persistence.crud;

import com.talataa.test.persistence.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MovieCrudRepository extends JpaRepository<MovieEntity, Long> {

    @Query(value = "select max(id) from MovieEntity")
    public Optional<Long> getMAxId();
}
