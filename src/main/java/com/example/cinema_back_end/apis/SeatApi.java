package com.example.cinema_back_end.apis;

import com.example.cinema_back_end.dtos.SeatDTO;
import com.example.cinema_back_end.services.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/seats")
public class SeatApi {
    @Autowired
    private ISeatService seatService;

    @GetMapping
    public List<SeatDTO> getSeatsByScheduleId(@RequestParam Integer scheduleId){
        return seatService.getSeatsByScheduleId(scheduleId);
    }
}
