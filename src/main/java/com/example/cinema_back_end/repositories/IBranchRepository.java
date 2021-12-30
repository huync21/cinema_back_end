package com.example.cinema_back_end.repositories;

import com.example.cinema_back_end.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBranchRepository extends JpaRepository<Branch, Integer> {
    @Query("SELECT b FROM Branch b where b.id in " +
            "(SELECT s.branch.id FROM Schedule s JOIN s.movie m WHERE s.movie.id = :movieId )")
    List<Branch> getBranchThatShowTheMovie(@Param("movieId") Integer movieId);
}