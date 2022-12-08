package com.talataa.test.domain.repository;

import com.talataa.test.domain.dto.CompanyDto;
import com.talataa.test.domain.exceptions.ElementNotFound;

import java.util.List;

public interface CompanyRepository {

    List<CompanyDto> getAll(int page, int size);

    List<CompanyDto> saveAll(List<CompanyDto> companies);

    CompanyDto getById(Long id) throws ElementNotFound;

    CompanyDto update(Long id, CompanyDto companyDto) throws ElementNotFound;

    CompanyDto create(CompanyDto companyDto);

    void delete(Long id) throws ElementNotFound;
}
