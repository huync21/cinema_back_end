package com.example.cinema_back_end.services;


import com.example.cinema_back_end.dtos.MovieDTO;


import java.util.List;

public interface IMovieService {
    List<MovieDTO> findAllShowingMovies();
    MovieDTO getById(Integer movieId);
}
