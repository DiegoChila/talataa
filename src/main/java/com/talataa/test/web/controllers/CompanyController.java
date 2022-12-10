package com.talataa.test.web.controllers;

import com.talataa.test.domain.dto.CompanyDto;
import com.talataa.test.domain.dto.response.GlobalResponseDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.service.CompanyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation("Get all companies")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok")
    })
    public ResponseEntity<GlobalResponseDto<List<CompanyDto>>> getAllCompanies(@RequestParam @Nullable String page, @RequestParam @Nullable String size) {
        return companyService.getAllCompanies(page, size);
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a collection detail")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Element not found")
    })
    public ResponseEntity<GlobalResponseDto<CompanyDto>> getCompanyById(@PathVariable String id) throws ElementNotFound {
        return companyService.getCompanyById(id);
    }

    @PostMapping
    @ApiOperation("Create a collection")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created")
    })
    public ResponseEntity<GlobalResponseDto<CompanyDto>> createCompany(@RequestBody CompanyDto companyDto) {
        return companyService.createCompany(companyDto);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update a collection")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Element not found")
    })
    public ResponseEntity<GlobalResponseDto<CompanyDto>> updateCompanyById(@PathVariable String id, @RequestBody CompanyDto companyDto) throws ElementNotFound {
        return companyService.updateCompanyById(id, companyDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a collection")
    @ApiResponses({
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "Element not found")
    })
    public ResponseEntity<GlobalResponseDto<Object>> deleteCompanyById(@PathVariable String id) throws ElementNotFound {
        return companyService.deleteCompanyById(id);
    }
}
