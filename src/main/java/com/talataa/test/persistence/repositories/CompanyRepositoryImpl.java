package com.talataa.test.persistence.repositories;

import com.talataa.test.domain.dto.CompanyDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.repository.CompanyRepository;
import com.talataa.test.persistence.crud.CompanyCrudRepository;
import com.talataa.test.persistence.entities.CompanyEntity;
import com.talataa.test.persistence.mappers.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyCrudRepository companyCrudRepository;

    @Override
    public List<CompanyDto> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return companyMapper.toCompanyDtos(companyCrudRepository.findAll(pageable).getContent());
    }

    @Override
    public List<CompanyDto> saveAll(List<CompanyDto> companies) {
        return companyMapper.toCompanyDtos(companyCrudRepository.saveAll(companyMapper.toCompanyEntities(companies)));
    }

    @Override
    public CompanyDto getById(Long id) throws ElementNotFound {
        Optional<CompanyEntity> companyEntity = companyCrudRepository.findById(id);
        return companyEntity.map(entity -> companyMapper.toCompanyDto(entity)).orElseThrow(ElementNotFound::new);
    }

    @Override
    public CompanyDto update(Long id, CompanyDto companyDto) throws ElementNotFound {
        CompanyDto dto = getById(id);
        if (!Objects.isNull(dto)) {
            CompanyEntity companyEntity = companyMapper.toCompanyEntity(dto);
            companyEntity.setName(companyDto.getName());
            companyEntity.setLogoPath(companyDto.getLogoPath());
            companyEntity.setOriginCountry(companyDto.getOriginCountry());

            return companyMapper.toCompanyDto(companyCrudRepository.save(companyEntity));
        }

        return null;
    }

    @Override
    public CompanyDto create(CompanyDto companyDto) {
        CompanyEntity companyEntity = companyMapper.toCompanyEntity(companyDto);
        Optional<Long> maxId = companyCrudRepository.getMAxId();
        if (maxId.isPresent()) {
            companyEntity.setIdCompany(maxId.get() + 1);
        } else {
            companyEntity.setIdCompany(1L);
        }
        return companyMapper.toCompanyDto(companyCrudRepository.save(companyEntity));
    }

    @Override
    public void delete(Long id) throws ElementNotFound {
        CompanyDto dto = getById(id);
        if (!Objects.isNull(dto)) {
            CompanyEntity companyEntity = companyMapper.toCompanyEntity(dto);
            companyCrudRepository.delete(companyEntity);
        }
    }
}
