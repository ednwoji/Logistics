package com.Logistics.Application.Logistics.Controllers;


import com.Logistics.Application.Logistics.Entities.Users;
import com.Logistics.Application.Logistics.Services.UserService;
import com.Logistics.Application.Logistics.Responses.UserResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/users")
public class AuthController {

    @Autowired
    UserService userService;


    @PostMapping("/saveuser")
    public ResponseEntity<?> addUser(@RequestBody Users users, UserResponses userResponses) {

        Users checkUser = userService.checkUser(users.getEmail());
        if(checkUser != null) {
            userResponses.setUser_id(checkUser.getUser_id());
            userResponses.setUser_name(checkUser.getUser_name());
            userResponses.setUser_password(checkUser.getUser_password());
            userResponses.setStatus("User Exists");
            return ResponseEntity.ok(userResponses);
        }
        else {
            users.setRole("user");
            users.setUser_password(BCrypt.hashpw(users.getUser_password(), BCrypt.gensalt()));
            return new ResponseEntity<>(userService.saveUser(users), CREATED);
        }
    }


    @PostMapping("/verifyuser")
    public ResponseEntity<?> verifyUser(@RequestBody Users users, UserResponses userResponses) {

        Users userCheck = userService.checkUser(users.getEmail());
        if(userCheck == null) {
            userResponses.setUser_id(0L);
            userResponses.setUser_name("Null");
            userResponses.setUser_password("Null");
            userResponses.setStatus("Wrong Email");

            ResponseEntity.ok(userResponses);
        }
        else {
            if (!BCrypt.checkpw(users.getUser_password(), userCheck.getUser_password())) {
                userResponses.setUser_id(0L);
                userResponses.setUser_name(userCheck.getUser_name());
                userResponses.setUser_password("Null");
                userResponses.setStatus("Wrong Password");
                return ResponseEntity.ok(userResponses);
            }

            else {

                userResponses.setUser_id(userCheck.getUser_id());
                userResponses.setUser_name(users.getUser_name());
                userResponses.setUser_password(userCheck.getUser_password());
                userResponses.setStatus("Verified");
                return ResponseEntity.ok(userResponses);
            }
        }
        return ResponseEntity.ok(null);
    }


    @GetMapping("listusers")
    public ResponseEntity<?> GetUsers() {
        return new ResponseEntity<>(userService.getAll(), OK);
    }

}
