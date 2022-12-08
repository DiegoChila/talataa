package com.talataa.test.persistence.mappers.impl;

import com.talataa.test.domain.dto.CollectionDto;
import com.talataa.test.persistence.entities.CollectionEntity;
import com.talataa.test.persistence.mappers.CollectionMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CollectionMapperImpl implements CollectionMapper {

    @Override
    public CollectionEntity toCollectionEntity(CollectionDto collectionDto) {
        if (Objects.isNull(collectionDto)) {
            return null;
        }
        return new CollectionEntity(collectionDto.getIdCollection(), collectionDto.getName(), collectionDto.getPosterPath(), collectionDto.getBackdropPath());
    }

    @Override
    public List<CollectionEntity> toCollectionEntities(List<CollectionDto> collectionDtos) {
        return collectionDtos.stream().map(this::toCollectionEntity).collect(Collectors.toList());
    }

    @Override
    public CollectionDto toCollectionDto(CollectionEntity collectionEntity) {
        if (Objects.isNull(collectionEntity)) {
            return null;
        }
        return new CollectionDto(collectionEntity.getIdCollection(), collectionEntity.getName(), collectionEntity.getPosterPath(), collectionEntity.getBackdropPath());
    }

    @Override
    public List<CollectionDto> toCollectionDtos(List<CollectionEntity> collectionEntities) {
        return collectionEntities.stream().map(this::toCollectionDto).collect(Collectors.toList());
    }
}
