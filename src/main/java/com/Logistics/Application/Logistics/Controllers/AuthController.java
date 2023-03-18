package com.Logistics.Application.Logistics.Controllers;


import com.Logistics.Application.Logistics.Entities.Users;
import com.Logistics.Application.Logistics.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    UserService userService;


    private ResponseEntity<Users> addUser(@RequestBody Users users) {


        Users checkUser = userService.checkUser(users.getEmail());

        if(checkUser == null) {

            return ResponseEntity.ok(users);
        }


        return ResponseEntity.ok(users);

    }


}
