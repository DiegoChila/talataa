package com.talataa.test.persistence.mappers;

import com.talataa.test.domain.dto.CollectionDto;
import com.talataa.test.persistence.entities.CollectionEntity;

import java.util.List;

public interface CollectionMapper {

    CollectionEntity toCollectionEntity(CollectionDto collectionDto);

    List<CollectionEntity> toCollectionEntities(List<CollectionDto> collectionDtos);

    CollectionDto toCollectionDto(CollectionEntity collectionEntity);

    List<CollectionDto> toCollectionDtos(List<CollectionEntity> collectionEntities);
}
