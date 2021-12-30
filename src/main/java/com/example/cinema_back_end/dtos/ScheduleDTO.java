package com.example.cinema_back_end.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ScheduleDTO {
    private int id;
    private LocalDate startDate;
    private LocalTime startTime;
    private BranchDTO branch;
    private RoomDTO room;
    private MovieDTO movie;
    private Double price;
}
