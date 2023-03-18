package com.Logistics.Application.Logistics.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "create_orders")
public class CreateOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String order_name;
    private String pickup_location;
    private String destination;
    private String sender_name;
    private String sender_email;
    private String sender_number;
    private String receiver_name;
    private String receiver_email;
    private String receiver_number;
    private String order_id;
    private String estimated_size;
}
