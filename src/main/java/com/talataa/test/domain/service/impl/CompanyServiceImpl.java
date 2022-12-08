package com.talataa.test.domain.service.impl;

import com.talataa.test.domain.dto.CompanyDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.repository.CompanyRepository;
import com.talataa.test.domain.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    private Pattern pattern = Pattern.compile("^\\d+$");

    @Override
    public ResponseEntity<GlobalResponseDto<List<CompanyDto>>> getAllCompanies(String page, String size) {
        int pageInt = 0;
        int sizeInt = 20;
        if (!Objects.isNull(page) && pattern.matcher(page).matches()) {
            pageInt = Integer.parseInt(page);
        }
        if (!Objects.isNull(size) && pattern.matcher(size).matches()) {
            sizeInt = Integer.parseInt(size);
        }
        return new ResponseEntity<>(new GlobalResponseDto<>(null, companyRepository.getAll(pageInt, sizeInt)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<CompanyDto>> getCompanyById(String id) throws ElementNotFound {
        return new ResponseEntity<>(new GlobalResponseDto<>(null, companyRepository.getById(Long.parseLong(id))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<CompanyDto>> createCompany(CompanyDto companyDto) {
        return new ResponseEntity<>(new GlobalResponseDto<>(null, companyRepository.create(companyDto)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<CompanyDto>> updateCompanyById(String id, CompanyDto companyDto) throws ElementNotFound {
        return new ResponseEntity<>(new GlobalResponseDto<>(null, companyRepository.update(Long.parseLong(id), companyDto)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GlobalResponseDto<Object>> deleteCompanyById(String id) throws ElementNotFound {
        companyRepository.delete(Long.parseLong(id));
        return new ResponseEntity<>(new GlobalResponseDto<>(null, true), HttpStatus.NO_CONTENT);
    }
}
