package com.example.cinema_back_end.services;

import com.example.cinema_back_end.dtos.SeatDTO;

import java.util.List;

public interface ISeatService {
    List<SeatDTO> getSeatsByScheduleId(Integer scheduleId);
}
