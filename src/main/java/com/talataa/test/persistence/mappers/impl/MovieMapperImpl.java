package com.talataa.test.persistence.mappers.impl;

import com.talataa.test.domain.dto.*;
import com.talataa.test.persistence.entities.*;
import com.talataa.test.persistence.mappers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapperImpl implements MovieMapper {

    @Autowired
    private CollectionMapper collectionMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private GenreMapper genreMapper;

    @Autowired
    private LanguageMapper languageMapper;

    @Override
    public MovieEntity toMovieEntity(MovieDto movieDto) {
        CollectionEntity collectionEntity = collectionMapper.toCollectionEntity(movieDto.getBelongsToCollection());
        List<CompanyEntity> companyEntities = companyMapper.toCompanyEntities(movieDto.getProductionCompanies());
        List<CountryEntity> countryEntities = countryMapper.toCountryEntities(movieDto.getProductionCountries());
        List<GenreEntity> genreEntities = genreMapper.toGenreEntities(movieDto.getGenres());
        List<LanguageEntity> languageEntities = languageMapper.toLanguageEntities(movieDto.getSpokenLanguages());

        return new MovieEntity(movieDto.getIdMovie(), movieDto.getAdult(), movieDto.getBackdropPath(), collectionEntity, movieDto.getBudget(), genreEntities,
                movieDto.getHomepage(), movieDto.getImdbId(), movieDto.getOriginalLanguage(), movieDto.getOriginalTitle(), movieDto.getOverview(), movieDto.getPopularity(),
                movieDto.getPosterPath(), companyEntities, countryEntities, movieDto.getReleaseDate(), movieDto.getRevenue(), movieDto.getRuntime(), languageEntities, movieDto.getStatus(),
                movieDto.getTagline(), movieDto.getTitle(), movieDto.getVideo(), movieDto.getVoteAverage(), movieDto.getVoteCount());
    }

    @Override
    public List<MovieEntity> toMovieEntities(List<MovieDto> movieDtos) {
        return movieDtos.stream().map(this::toMovieEntity).collect(Collectors.toList());
    }

    @Override
    public MovieDto toMovieDto(MovieEntity movieEntity) {
        CollectionDto collectionDto = collectionMapper.toCollectionDto(movieEntity.getBelongsToCollection());
        List<CompanyDto> companyDtos = companyMapper.toCompanyDtos(movieEntity.getProductionCompanies());
        List<CountryDto> countryDtos = countryMapper.toCountryDtos(movieEntity.getProductionCountries());
        List<GenreDto> genreDtos = genreMapper.toGenreDtos(movieEntity.getGenres());
        List<LanguageDto> languageDtos = languageMapper.toLanguageDtos(movieEntity.getSpokenLanguages());

        return new MovieDto(movieEntity.getIdMovie(), movieEntity.getAdult(), movieEntity.getBackdropPath(), collectionDto, movieEntity.getBudget(), genreDtos,
                movieEntity.getHomepage(), movieEntity.getImdbId(), movieEntity.getOriginalLanguage(), movieEntity.getOriginalTitle(), movieEntity.getOverview(), movieEntity.getPopularity(),
                movieEntity.getPosterPath(), companyDtos, countryDtos, movieEntity.getReleaseDate(), movieEntity.getRevenue(), movieEntity.getRuntime(), languageDtos,
                movieEntity.getStatus(), movieEntity.getTagline(), movieEntity.getTitle(), movieEntity.getVideo(), movieEntity.getVoteAverage(), movieEntity.getVoteCount());
    }

    @Override
    public List<MovieDto> toMovieDtos(List<MovieEntity> movieEntities) {
        return movieEntities.stream().map(this::toMovieDto).collect(Collectors.toList());
    }
}
