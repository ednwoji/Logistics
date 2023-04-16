package com.Logistics.Application.Logistics.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebControllers {


    @GetMapping("/home")
    public String homePage() {

        return "index";
    }

    @GetMapping("/started")
    public String Signup() {

        return "signup";
    }

}
