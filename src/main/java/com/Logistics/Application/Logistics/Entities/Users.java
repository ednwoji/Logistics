package com.Logistics.Application.Logistics.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "logistics_users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String user_name;
    private String user_password;
    private String role;
    private String address;
    private String email;
    private String phone;
}
