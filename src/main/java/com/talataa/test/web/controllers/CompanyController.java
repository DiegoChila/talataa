package com.talataa.test.web.controllers;

import com.talataa.test.domain.dto.CompanyDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<GlobalResponseDto<List<CompanyDto>>> getAllCompanies(@RequestParam @Nullable String page, @RequestParam @Nullable String size) {
        return companyService.getAllCompanies(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalResponseDto<CompanyDto>> getCompanyById(@PathVariable String id) throws ElementNotFound {
        return companyService.getCompanyById(id);
    }

    @PostMapping
    public ResponseEntity<GlobalResponseDto<CompanyDto>> createCompany(@RequestBody CompanyDto companyDto) {
        return companyService.createCompany(companyDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalResponseDto<CompanyDto>> updateCompanyById(@PathVariable String id, @RequestBody CompanyDto companyDto) throws ElementNotFound {
        return companyService.updateCompanyById(id, companyDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalResponseDto<Object>> deleteCompanyById(@PathVariable String id) throws ElementNotFound {
        return companyService.deleteCompanyById(id);
    }
}
