package com.talataa.test.persistence.repositories;

import com.talataa.test.domain.dto.CollectionDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.repository.CollectionRepository;
import com.talataa.test.persistence.crud.CollectionCrudRepository;
import com.talataa.test.persistence.entities.CollectionEntity;
import com.talataa.test.persistence.mappers.CollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class CollectionRepositoryImpl implements CollectionRepository {

    @Autowired
    private CollectionMapper collectionMapper;

    @Autowired
    private CollectionCrudRepository collectionCrudRepository;

    @Override
    public List<CollectionDto> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return collectionMapper.toCollectionDtos(collectionCrudRepository.findAll(pageable).getContent());
    }

    @Override
    public List<CollectionDto> saveAll(List<CollectionDto> collections) {
        return collectionMapper.toCollectionDtos(collectionCrudRepository.saveAll(collectionMapper.toCollectionEntities(collections)));
    }

    @Override
    public CollectionDto getById(Long id) throws ElementNotFound {
        Optional<CollectionEntity> collectionEntity = collectionCrudRepository.findById(id);
        return collectionEntity.map(entity -> collectionMapper.toCollectionDto(entity)).orElseThrow(ElementNotFound::new);
    }

    @Override
    public CollectionDto update(Long id, CollectionDto collectionDto) throws ElementNotFound {
        CollectionDto dto = getById(id);
        if (!Objects.isNull(dto)) {
            CollectionEntity collectionEntity =  collectionMapper.toCollectionEntity(dto);
            collectionEntity.setName(collectionDto.getName());
            collectionEntity.setBackdropPath(collectionDto.getBackdropPath());
            collectionEntity.setPosterPath(collectionDto.getPosterPath());

            return collectionMapper.toCollectionDto(collectionCrudRepository.save(collectionEntity));
        }

        return null;
    }

    @Override
    public CollectionDto create(CollectionDto collectionDto) {
        CollectionEntity collectionEntity = collectionMapper.toCollectionEntity(collectionDto);
        Optional<Long> maxId = collectionCrudRepository.getMAxId();
        if (maxId.isPresent()) {
            collectionEntity.setIdCollection(maxId.get() + 1);
        } else {
            collectionEntity.setIdCollection(1L);
        }
        return collectionMapper.toCollectionDto(collectionCrudRepository.save(collectionEntity));
    }

    @Override
    public void delete(Long id) throws ElementNotFound {
        CollectionDto dto = getById(id);
        if (!Objects.isNull(dto)) {
            CollectionEntity collectionEntity =  collectionMapper.toCollectionEntity(dto);
            collectionCrudRepository.delete(collectionEntity);
        }
    }
}
