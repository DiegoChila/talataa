package com.talataa.test.persistence.crud;

import com.talataa.test.persistence.entities.CollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CollectionCrudRepository extends JpaRepository<CollectionEntity, Long> {

    @Query(value = "select max(id) from CollectionEntity")
    public Optional<Long> getMAxId();
}
