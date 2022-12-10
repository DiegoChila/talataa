# Talataa service

This project is a connector with the movie api. The service get a list of data movies and persist it in a H2 database, then, any client can interact with the data.

## Services

### Movies
*  Get all movies 
    * Path: /movies
    * Method: GET
    * Pagination: The pagination by default is 1, if the client wants to change it, must include the request param page=number-page
    * Size: The size of data by default is 20, if the client wants to change it, must include the request param size=size-number   
*  Get a movie detail
    * Path: /movies/{movie-id}
    * Method: GET
*  Create a movie
    * Path: /movies
    * Method: POST
*  Update a movie
    * Path: /movies/{movie-id}
    * Method: PUT
*  Delete a movie
    * Path: /movies/{movie-id}
    * Method: Delete

### Collections
*  Get all collections
    * Path: /collections
    * Method: GET
    * Pagination: The pagination by default is 1, if the client wants to change it, must include the request param page=number-page
    * Size: The size of data by default is 20, if the client wants to change it, must include the request param size=size-number
*  Get a collection detail
    * Path: /collections/{collection-id}
    * Method: GET
*  Create a collection
    * Path: /collections
    * Method: POST
*  Update a collection
    * Path: /collections/{collection-id}
    * Method: PUT
*  Delete a collection
    * Path: /collections/{collection-id}
    * Method: Delete

### Companies
*  Get all companies
    * Path: /companies
    * Method: GET
    * Pagination: The pagination by default is 1, if the client wants to change it, must include the request param page=number-page
    * Size: The size of data by default is 20, if the client wants to change it, must include the request param size=size-number
*  Get a company detail
    * Path: /companies/{company-id}
    * Method: GET
*  Create a company
    * Path: /companies
    * Method: POST
*  Update a company
    * Path: /companies/{company-id}
    * Method: PUT
*  Delete a company
    * Path: /companies/{company-id}
    * Method: Delete

### Countries
*  Get all countries
    * Path: /countries
    * Method: GET
    * Pagination: The pagination by default is 1, if the client wants to change it, must include the request param page=number-page
    * Size: The size of data by default is 20, if the client wants to change it, must include the request param size=size-number
*  Get a country detail
    * Path: /countries/{country-id}
    * Method: GET
*  Create a country
    * Path: /countries
    * Method: POST
*  Update a country
    * Path: /countries/{country-id}
    * Method: PUT
*  Delete a country
    * Path: /countries/{country-id}
    * Method: Delete

### Genres
*  Get all genres
    * Path: /genres
    * Method: GET
    * Pagination: The pagination by default is 1, if the client wants to change it, must include the request param page=number-page
    * Size: The size of data by default is 20, if the client wants to change it, must include the request param size=size-number
*  Get a genre detail
    * Path: /genres/{genre-id}
    * Method: GET
*  Create a genre
    * Path: /genres
    * Method: POST
*  Update a genre
    * Path: /genres/{genre-id}
    * Method: PUT
*  Delete a genre
    * Path: /genres/{genre-id}
    * Method: Delete

### Languages
*  Get all languages
    * Path: /languages
    * Method: GET
    * Pagination: The pagination by default is 1, if the client wants to change it, must include the request param page=number-page
    * Size: The size of data by default is 20, if the client wants to change it, must include the request param size=size-number
*  Get a language detail
    * Path: /languages/{language-id}
    * Method: GET
*  Create a language
    * Path: /languages
    * Method: POST
*  Update a language
    * Path: /languages/{language-id}
    * Method: PUT
*  Delete a language
    * Path: /languages/{language-id}
    * Method: Delete


## More information at http://ec2-3-145-21-46.us-east-2.compute.amazonaws.com/swagger-ui.html
