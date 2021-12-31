package com.example.cinema_back_end.services;

import com.example.cinema_back_end.dtos.RoomDTO;

import java.util.List;

public interface IRoomService {
    List<RoomDTO> getRooms(Integer movieId,Integer branchId,String startDate,String startTime);
}
