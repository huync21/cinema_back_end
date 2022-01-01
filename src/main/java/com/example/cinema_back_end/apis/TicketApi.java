package com.example.cinema_back_end.apis;

import com.example.cinema_back_end.dtos.TicketDTO;
import com.example.cinema_back_end.services.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tickets")
public class TicketApi {
    @Autowired
    private ITicketService ticketService;

    @GetMapping
    public List<TicketDTO> getTicketsByUserId(@RequestParam Integer userId){
        return ticketService.getTicketsByUserId(userId);
    }
}
