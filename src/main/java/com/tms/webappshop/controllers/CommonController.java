package com.tms.webappshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class CommonController {

    @GetMapping()
    public String mainRedirect() {
        return "redirect:/api/v2/products";
    }
}
