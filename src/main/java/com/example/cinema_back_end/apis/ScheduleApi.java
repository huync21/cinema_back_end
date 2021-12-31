package com.example.cinema_back_end.apis;

import com.example.cinema_back_end.dtos.ScheduleDTO;
import com.example.cinema_back_end.services.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/schedule", produces = "application/json")
public class ScheduleApi {
    @Autowired
    private IScheduleService scheduleService;

    @GetMapping("/start-times")
    public List<String> getStartTimes(@RequestParam Integer movieId, @RequestParam Integer branchId,
                                         @RequestParam String startDate) {
        return scheduleService.getStartTimes(movieId,branchId,LocalDate.parse(startDate));
    }

    @GetMapping
    public List<ScheduleDTO> getSchedules(@RequestParam Integer movieId,  @RequestParam Integer branchId,
                                          @RequestParam String startDate,@RequestParam String startTime,
                                          @RequestParam Integer roomId){
        return scheduleService.getSchedules(movieId,branchId,startDate,startTime,roomId);
    }
}
