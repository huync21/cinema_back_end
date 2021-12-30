package com.example.cinema_back_end.repositories;

import com.example.cinema_back_end.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomRepository extends JpaRepository<Room, Integer> {
}