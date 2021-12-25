package com.example.cinema_back_end.dtos;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class BillDTO {
    private int id;
    private LocalDate createdDate;
    private List<TicketDTO> listTickets;
}
