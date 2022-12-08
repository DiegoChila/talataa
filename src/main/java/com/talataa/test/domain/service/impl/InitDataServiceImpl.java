package com.talataa.test.domain.service.impl;

import com.talataa.test.domain.dto.*;
import com.talataa.test.domain.dto.movie_service.MoviePopularResponseDto;
import com.talataa.test.domain.dto.movie_service.MoviePopularResultDto;
import com.talataa.test.domain.repository.*;
import com.talataa.test.domain.service.InitDataService;
import com.talataa.test.domain.service.MovieRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class InitDataServiceImpl implements InitDataService {

    @Autowired
    private MovieRestTemplate movieRestTemplate;

    @Autowired
    private CollectionRepository collectionRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void initData() {
        System.out.println("Inicia la carga");

        List<Long> moviesIds = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            HttpEntity<MoviePopularResponseDto> popularMovies = movieRestTemplate.getPopularMovies(Integer.toString(i + 1));
            for (MoviePopularResultDto result : popularMovies.getBody().getResults()) {
                moviesIds.add(result.getId());
            }
        }

        List<CollectionDto> collectionDtos = new ArrayList<>();
        List<CompanyDto> companyDtos = new ArrayList<>();
        List<CountryDto> countryDtos = new ArrayList<>();
        List<GenreDto> genreDtos = new ArrayList<>();
        List<LanguageDto> languageDtos = new ArrayList<>();
        List<MovieDto> movieDtos = new ArrayList<>();

        for (Long id: moviesIds) {
            HttpEntity<MovieDto> movieDtoHttpEntity = movieRestTemplate.getMovieDetail(Long.toString(id));
            if (!Objects.isNull(movieDtoHttpEntity.getBody().getBelongsToCollection())) {
                collectionDtos.add(movieDtoHttpEntity.getBody().getBelongsToCollection());
            }
            companyDtos.addAll(movieDtoHttpEntity.getBody().getProductionCompanies());
            countryDtos.addAll(movieDtoHttpEntity.getBody().getProductionCountries());
            genreDtos.addAll(movieDtoHttpEntity.getBody().getGenres());
            languageDtos.addAll(movieDtoHttpEntity.getBody().getSpokenLanguages());
            movieDtos.add(movieDtoHttpEntity.getBody());
        }

        collectionRepository.saveAll(collectionDtos);
        companyRepository.saveAll(companyDtos);
        countryRepository.saveAll(countryDtos);
        genreRepository.saveAll(genreDtos);
        languageRepository.saveAll(languageDtos);
        movieRepository.saveAll(movieDtos);

        System.out.println("Finaliza la carga");
    }
}
