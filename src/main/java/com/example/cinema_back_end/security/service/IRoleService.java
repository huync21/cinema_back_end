package com.example.cinema_back_end.security.service;


import com.example.cinema_back_end.entities.Role;
import com.example.cinema_back_end.services.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}