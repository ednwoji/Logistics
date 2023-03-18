package com.Logistics.Application.Logistics.Repositories;

import com.Logistics.Application.Logistics.Entities.CreateOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<CreateOrders, Long> {
}
