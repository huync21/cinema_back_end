package com.example.cinema_back_end.services;

import com.example.cinema_back_end.dtos.MovieDTO;
import com.example.cinema_back_end.entities.Movie;
import com.example.cinema_back_end.repositories.IMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService{

    @Autowired
    private IMovieRepository  movieRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<MovieDTO> findAllShowingMovies() {
        return movieRepository.findMoviesByIsShowingOrderByIdDesc(1)
                .stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());
    }
}
