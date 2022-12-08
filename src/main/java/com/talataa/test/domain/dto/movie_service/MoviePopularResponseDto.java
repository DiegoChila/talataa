package com.talataa.test.domain.dto.movie_service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MoviePopularResponseDto {

    @JsonProperty("page")
    private Long page;

    @JsonProperty("results")
    private List<MoviePopularResultDto> results;

    @JsonProperty("total_pages")
    private Long totalPages;

    @JsonProperty("total_results")
    private Long totalResults;

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public List<MoviePopularResultDto> getResults() {
        return results;
    }

    public void setResults(List<MoviePopularResultDto> results) {
        this.results = results;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

    @Override
    public String toString() {
        return "MoviePopularResponseDto{" +
                "page=" + page +
                ", results=" + results.size() +
                ", totalPages=" + totalPages +
                ", totalResults=" + totalResults +
                '}';
    }
}
