package com.Logistics.Application.Logistics.Services;

import com.Logistics.Application.Logistics.Entities.CreateOrders;

import java.util.List;

public interface OrderService {
    Object saveOrder(CreateOrders createOrders);

    List<CreateOrders> getAll(String useremail);
}
