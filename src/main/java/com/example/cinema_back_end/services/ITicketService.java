package com.example.cinema_back_end.services;

import com.example.cinema_back_end.dtos.TicketDTO;

import java.util.List;

public interface ITicketService {
    List<TicketDTO> getTicketsByUserId(Integer userId);
}
