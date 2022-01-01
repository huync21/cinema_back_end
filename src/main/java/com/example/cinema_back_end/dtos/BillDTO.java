package com.example.cinema_back_end.dtos;

import com.example.cinema_back_end.entities.User;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BillDTO {
    private int id;
    private LocalDateTime createdTime;
    private List<TicketDTO> listTickets;
    private User user;
}
