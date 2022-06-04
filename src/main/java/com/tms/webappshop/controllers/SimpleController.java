package com.tms.webappshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }
}
