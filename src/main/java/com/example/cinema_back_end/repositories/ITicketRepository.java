package com.example.cinema_back_end.repositories;

import com.example.cinema_back_end.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findTicketsBySchedule_Id(Integer scheduleId);
    List<Ticket> findTicketsBySchedule_IdAndSeat_Id(Integer scheduleId,Integer seatId);
    @Query("SELECT t FROM Ticket t WHERE t.bill.id IN (SELECT b.id FROM Bill b WHERE b.user.id=:userId) ORDER BY t.id DESC")
    List<Ticket> findTicketsByUserId(@Param("userId") Integer userId);
}