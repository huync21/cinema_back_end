package com.example.cinema_back_end.dtos;

import lombok.Data;

@Data
public class TicketDTO {
    private int id;
    private String qrImageURL;
    private double price;
    private ScheduleDTO schedule;
    private SeatDTO seat;
}
