package com.Logistics.Application.Logistics.Controllers;


import com.Logistics.Application.Logistics.Entities.CreateOrders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {


    public ResponseEntity<?> createOrder(@RequestBody CreateOrders createOrders) {



    }
}
