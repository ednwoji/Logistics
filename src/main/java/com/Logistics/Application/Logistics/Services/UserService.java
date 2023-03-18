package com.Logistics.Application.Logistics.Services;

import com.Logistics.Application.Logistics.Entities.Users;

import java.util.List;

public interface UserService {
    Users checkUser(String email);

    Object saveUser(Users users);

    List<Users> getAll();
}
