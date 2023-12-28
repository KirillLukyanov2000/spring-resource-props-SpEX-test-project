package ru.lukyanov.service;

import ru.lukyanov.entity.Movie;
import ru.lukyanov.repo.MovieRepo;

public class MovieService {

    private MovieRepo movieRepo;

    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public Movie getMovieById(Long id){

        Movie movieById = movieRepo.getById(id);

        return movieById;
    }


}