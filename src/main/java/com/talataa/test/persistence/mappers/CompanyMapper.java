package com.talataa.test.persistence.mappers;

import com.talataa.test.domain.dto.CompanyDto;
import com.talataa.test.persistence.entities.CompanyEntity;

import java.util.List;

public interface CompanyMapper {

    CompanyEntity toCompanyEntity(CompanyDto companyDto);

    List<CompanyEntity> toCompanyEntities(List<CompanyDto> companyDtos);

    CompanyDto toCompanyDto(CompanyEntity companyEntity);

    List<CompanyDto> toCompanyDtos(List<CompanyEntity> companyEntities);
}
