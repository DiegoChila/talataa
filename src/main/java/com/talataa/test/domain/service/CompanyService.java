package com.talataa.test.domain.service;

import com.talataa.test.domain.dto.CompanyDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyService {

     ResponseEntity<GlobalResponseDto<List<CompanyDto>>> getAllCompanies(String page, String size);

     ResponseEntity<GlobalResponseDto<CompanyDto>> getCompanyById(String id) throws ElementNotFound;

     ResponseEntity<GlobalResponseDto<CompanyDto>> createCompany(CompanyDto companyDto);

     ResponseEntity<GlobalResponseDto<CompanyDto>> updateCompanyById(String id, CompanyDto companyDto) throws ElementNotFound;

     ResponseEntity<GlobalResponseDto<Object>> deleteCompanyById(String id) throws ElementNotFound;
}
