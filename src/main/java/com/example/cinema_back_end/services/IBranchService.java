package com.example.cinema_back_end.services;

import com.example.cinema_back_end.dtos.BranchDTO;

import java.util.List;

public interface IBranchService {
    List<BranchDTO> getBranchesThatShowTheMovie(Integer movieId);
}
