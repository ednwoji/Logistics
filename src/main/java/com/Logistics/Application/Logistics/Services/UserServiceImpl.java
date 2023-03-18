package com.Logistics.Application.Logistics.Services;


import com.Logistics.Application.Logistics.Entities.Users;
import com.Logistics.Application.Logistics.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Override
    public Users checkUser(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Object saveUser(Users users) {
        return userRepository.save(users);
    }

    @Override
    public List<Users> getAll() {
        return userRepository.findAll();
    }
}
