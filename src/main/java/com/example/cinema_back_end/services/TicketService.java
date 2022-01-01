package com.example.cinema_back_end.services;

import com.example.cinema_back_end.dtos.TicketDTO;
import com.example.cinema_back_end.repositories.ITicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService implements ITicketService{
    @Autowired
    private ITicketRepository ticketRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<TicketDTO> getTicketsByUserId(Integer userId) {
        return ticketRepository.findTicketsByUserId(userId)
                .stream().map(ticket -> modelMapper.map(ticket,TicketDTO.class))
                .collect(Collectors.toList());
    }
}
