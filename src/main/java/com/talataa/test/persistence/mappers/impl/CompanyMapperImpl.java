package com.talataa.test.persistence.mappers.impl;

import com.talataa.test.domain.dto.CompanyDto;
import com.talataa.test.persistence.entities.CompanyEntity;
import com.talataa.test.persistence.mappers.CompanyMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyMapperImpl implements CompanyMapper {
    @Override
    public CompanyEntity toCompanyEntity(CompanyDto companyDto) {
        return new CompanyEntity(companyDto.getIdCompany(), companyDto.getLogoPath(), companyDto.getName(), companyDto.getOriginCountry());
    }

    @Override
    public List<CompanyEntity> toCompanyEntities(List<CompanyDto> companyDtos) {
        return companyDtos.stream().map(this::toCompanyEntity).collect(Collectors.toList());
    }

    @Override
    public CompanyDto toCompanyDto(CompanyEntity companyEntity) {
        return new CompanyDto(companyEntity.getIdCompany(), companyEntity.getLogoPath(), companyEntity.getName(), companyEntity.getOriginCountry());
    }

    @Override
    public List<CompanyDto> toCompanyDtos(List<CompanyEntity> companyEntities) {
        return companyEntities.stream().map(this::toCompanyDto).collect(Collectors.toList());
    }
}
