package com.talataa.test.persistence.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "movies")
public class MovieEntity {

    @Id
    @Column(name = "id")
    private Long idMovie;

    @Column(name = "adult")
    private Boolean adult;

    @Column(name = "backdrop_path")
    private String backdropPath;

    @OneToOne
    private CollectionEntity belongsToCollection;

    @Column(name = "budget")
    private Long budget;

    @ManyToMany
    private List<GenreEntity> genres;

    @Column(name = "homepage")
    private String homepage;

    @Column(name = "imdb_id")
    private String imdbId;

    @Column(name = "original_language")
    private String originalLanguage;

    @Column(name = "original_title")
    private String originalTitle;

    @Column(name = "overview", columnDefinition = "LONGTEXT")
    private String overview;

    @Column(name = "popularity")
    private Double popularity;

    @Column(name = "poster_path")
    private String posterPath;

    @ManyToMany
    private List<CompanyEntity> productionCompanies;

    @ManyToMany
    private List<CountryEntity> productionCountries;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "revenue")
    private Long revenue;

    @Column(name = "runtime")
    private Long runtime;

    @ManyToMany
    private List<LanguageEntity> spokenLanguages;

    @Column(name = "status")
    private String status;

    @Column(name = "tagline")
    private String tagline;

    @Column(name = "title")
    private String title;

    @Column(name = "video")
    private Boolean video;

    @Column(name = "vote_average")
    private Double voteAverage;

    @Column(name = "vote_count")
    private Long voteCount;

    public MovieEntity() {
    }

    public MovieEntity(Long idMovie, Boolean adult, String backdropPath, CollectionEntity belongsToCollection, Long budget, List<GenreEntity> genres, String homepage, String imdbId, String originalLanguage, String originalTitle, String overview, Double popularity, String posterPath, List<CompanyEntity> productionCompanies, List<CountryEntity> productionCountries, String releaseDate, Long revenue, Long runtime, List<LanguageEntity> spokenLanguages, String status, String tagline, String title, Boolean video, Double voteAverage, Long voteCount) {
        this.idMovie = idMovie;
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.belongsToCollection = belongsToCollection;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.imdbId = imdbId;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.productionCompanies = productionCompanies;
        this.productionCountries = productionCountries;
        this.releaseDate = releaseDate;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spokenLanguages = spokenLanguages;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public Long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public CollectionEntity getBelongsToCollection() {
        return belongsToCollection;
    }

    public void setBelongsToCollection(CollectionEntity belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public List<GenreEntity> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreEntity> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<CompanyEntity> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<CompanyEntity> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<CountryEntity> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<CountryEntity> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getRevenue() {
        return revenue;
    }

    public void setRevenue(Long revenue) {
        this.revenue = revenue;
    }

    public Long getRuntime() {
        return runtime;
    }

    public void setRuntime(Long runtime) {
        this.runtime = runtime;
    }

    public List<LanguageEntity> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<LanguageEntity> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }
}
