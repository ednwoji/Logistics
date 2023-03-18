package com.Logistics.Application.Logistics.Controllers;


import com.Logistics.Application.Logistics.Entities.CreateOrders;
import com.Logistics.Application.Logistics.Entities.Users;
import com.Logistics.Application.Logistics.Responses.UserResponses;
import com.Logistics.Application.Logistics.Services.OrderService;
import com.Logistics.Application.Logistics.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;


    @PostMapping("/create-order")
    public ResponseEntity<?> createOrder(@RequestBody CreateOrders createOrders) {

        if(createOrders.getOrder_name() == null || createOrders.getDestination() == null || createOrders.getReceiver_name() == null ||
        createOrders.getPickup_location() == null) {
            return ResponseEntity.ok("Kindly fill in all details for easy tracking");
        }
        else {
            createOrders.setOrder_status("PENDING PICKUP");
            return new ResponseEntity<>(orderService.saveOrder(createOrders), CREATED);
        }
    }


    @GetMapping("/list-orders/{useremail}")
    public ResponseEntity<?> GetOrdersByUser(@PathVariable("useremail") String useremail, UserResponses userResponses){

        Users checkUser = userService.checkUser(useremail);

        if(checkUser == null) {
            userResponses.setUser_id(0L);
            userResponses.setUser_name("Null");
            userResponses.setUser_password("Null");
            userResponses.setStatus("Wrong Email");
            return ResponseEntity.ok(userResponses);
        }

        else {
            return new ResponseEntity<>(orderService.getAll(useremail), OK);
        }
    }
}
