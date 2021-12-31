package com.example.cinema_back_end.services;

import com.example.cinema_back_end.dtos.ScheduleDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IScheduleService {
    List<String> getStartTimes(Integer movieId, Integer branchId, LocalDate startDate);
    List<ScheduleDTO> getSchedules(Integer movieId,Integer branchId,String startDate, String startTime,
                                   Integer roomId);
}
