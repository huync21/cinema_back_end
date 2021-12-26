package com.example.cinema_back_end.apis;

import com.example.cinema_back_end.dtos.MovieDTO;
import com.example.cinema_back_end.services.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/api/movies", produces = "application/json")
public class MovieApi {
    @Autowired
    private IMovieService movieService;

    @GetMapping("/showing")
    public ResponseEntity<List<MovieDTO>> findAllShowingMovies(){
        return new ResponseEntity<>(movieService.findAllShowingMovies(), HttpStatus.OK);
    }
}
