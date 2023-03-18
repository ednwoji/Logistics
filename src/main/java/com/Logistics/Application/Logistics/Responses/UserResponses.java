package com.Logistics.Application.Logistics.Responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponses {

    private Long user_id;
    private String user_name;
    private String user_password;
    private String status;
}
