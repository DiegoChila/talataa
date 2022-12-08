package com.talataa.test.persistence.crud;

import com.talataa.test.persistence.entities.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageCrudRepository extends JpaRepository<LanguageEntity, String> {
}
