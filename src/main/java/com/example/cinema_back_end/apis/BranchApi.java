package com.example.cinema_back_end.apis;

import com.example.cinema_back_end.dtos.BranchDTO;
import com.example.cinema_back_end.repositories.IBranchRepository;
import com.example.cinema_back_end.services.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/api/branches", produces = "application/json")
public class BranchApi {
    @Autowired
    private IBranchService branchService;

    @GetMapping
    private ResponseEntity<List<BranchDTO>> getBranchesThatShowTheMovie(@RequestParam Integer movieId){
        return new ResponseEntity<>(branchService.getBranchesThatShowTheMovie(movieId), HttpStatus.OK);
    }
}
