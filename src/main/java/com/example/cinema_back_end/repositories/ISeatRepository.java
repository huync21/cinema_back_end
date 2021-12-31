package com.example.cinema_back_end.repositories;

import com.example.cinema_back_end.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISeatRepository extends JpaRepository<Seat, Integer> {
    List<Seat> getSeatByRoom_Id(Integer roomId);
}