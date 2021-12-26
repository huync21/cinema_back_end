package com.example.cinema_back_end.dtos;

import lombok.Data;

@Data
public class BranchDTO {
    private int id;
    private String imgURL;
    private String name;
    private String diaChi;
    private String phoneNo;
}
