package com.talataa.test.persistence.repositories;

import com.talataa.test.domain.dto.MovieDto;
import com.talataa.test.domain.exceptions.ElementNotFound;
import com.talataa.test.domain.repository.MovieRepository;
import com.talataa.test.persistence.crud.MovieCrudRepository;
import com.talataa.test.persistence.entities.MovieEntity;
import com.talataa.test.persistence.mappers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    @Autowired
    private MovieMapper movieMapper;

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

    @Autowired
    private MovieCrudRepository movieCrudRepository;

    @Override
    public List<MovieDto> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return movieMapper.toMovieDtos(movieCrudRepository.findAll(pageable).getContent());
    }

    @Override
    public List<MovieDto> saveAll(List<MovieDto> movies) {
        return movieMapper.toMovieDtos(movieCrudRepository.saveAll(movieMapper.toMovieEntities(movies)));
    }

    @Override
    public MovieDto getById(Long id) throws ElementNotFound {
        Optional<MovieEntity> movieEntity = movieCrudRepository.findById(id);
        return movieEntity.map(entity -> movieMapper.toMovieDto(entity)).orElseThrow(ElementNotFound::new);
    }

    @Override
    public MovieDto update(Long id, MovieDto movieDto) throws ElementNotFound {
        MovieDto dto = getById(id);
        if (!Objects.isNull(dto)) {
            MovieEntity movieEntity = movieMapper.toMovieEntity(dto);
            movieEntity.setAdult(movieDto.getAdult());
            movieEntity.setBudget(movieDto.getBudget());
            movieEntity.setBackdropPath(movieDto.getBackdropPath());
            movieEntity.setGenres(genreMapper.toGenreEntities(movieDto.getGenres()));
            movieEntity.setHomepage(movieDto.getHomepage());
            movieEntity.setBelongsToCollection(collectionMapper.toCollectionEntity(movieDto.getBelongsToCollection()));
            movieEntity.setImdbId(movieDto.getImdbId());
            movieEntity.setOriginalLanguage(movieDto.getOriginalLanguage());
            movieEntity.setOriginalTitle(movieDto.getOriginalTitle());
            movieEntity.setOverview(movieDto.getOverview());
            movieEntity.setPopularity(movieDto.getPopularity());
            movieEntity.setPosterPath(movieDto.getPosterPath());
            movieEntity.setProductionCompanies(companyMapper.toCompanyEntities(movieDto.getProductionCompanies()));
            movieEntity.setProductionCountries(countryMapper.toCountryEntities(movieDto.getProductionCountries()));
            movieEntity.setReleaseDate(movieDto.getReleaseDate());
            movieEntity.setRevenue(movieDto.getRevenue());
            movieEntity.setRuntime(movieDto.getRuntime());
            movieEntity.setSpokenLanguages(languageMapper.toLanguageEntities(movieDto.getSpokenLanguages()));
            movieEntity.setStatus(movieDto.getStatus());
            movieEntity.setTagline(movieDto.getTagline());
            movieEntity.setTitle(movieDto.getTitle());
            movieEntity.setVideo(movieDto.getVideo());
            movieEntity.setVoteAverage(movieDto.getVoteAverage());
            movieEntity.setVoteCount(movieDto.getVoteCount());

            return movieMapper.toMovieDto(movieCrudRepository.save(movieEntity));
        }

        return null;
    }

    @Override
    public MovieDto create(MovieDto movieDto) {
        MovieEntity movieEntity = movieMapper.toMovieEntity(movieDto);
        Optional<Long> maxId = movieCrudRepository.getMAxId();
        if (maxId.isPresent()) {
            movieEntity.setIdMovie(maxId.get() + 1);
        } else {
            movieEntity.setIdMovie(1L);
        }
        return movieMapper.toMovieDto(movieCrudRepository.save(movieEntity));
    }

    @Override
    public void delete(Long id) throws ElementNotFound {
        MovieDto dto = getById(id);
        if (!Objects.isNull(dto)) {
            MovieEntity movieEntity = movieMapper.toMovieEntity(dto);
            movieCrudRepository.delete(movieEntity);
        }
    }
}
