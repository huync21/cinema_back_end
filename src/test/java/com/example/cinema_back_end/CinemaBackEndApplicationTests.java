package com.example.cinema_back_end;

import com.example.cinema_back_end.repositories.IScheduleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class CinemaBackEndApplicationTests {
    @Autowired
    private IScheduleRepository scheduleRepository;
    @Test
    void contextLoads() {
        scheduleRepository.getStartTimeByMovie_IdAndBranch_IdAndStartDate(7,1, LocalDate.parse("2021-01-05"))
                .stream().forEach(System.out::println);
    }

}
