package com.example.cinema_back_end.repositories;

import com.example.cinema_back_end.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IScheduleRepository extends JpaRepository<Schedule, Integer> {
}