package com.Logistics.Application.Logistics.Services;


import com.Logistics.Application.Logistics.Entities.CreateOrders;
import com.Logistics.Application.Logistics.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Object saveOrder(CreateOrders createOrders) {
        return orderRepository.save(createOrders);
    }

    @Override
    public List<CreateOrders> getAll(String useremail) {
        return orderRepository.findBySenderEmail(useremail);
    }

    @Override
    public List<CreateOrders> getOrders() {
        return orderRepository.findAll();
    }
}
