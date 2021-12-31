package com.example.cinema_back_end.repositories;

import com.example.cinema_back_end.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findTicketsBySchedule_Id(Integer scheduleId);
}