package ru.sasha.trzbd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authorized")
public class authorizedUserController {

    @GetMapping()
    public String authorizedHome(){
        return "user/access";
    }
}
