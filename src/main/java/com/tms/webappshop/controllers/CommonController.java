package com.tms.webappshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping
public class CommonController {

    @GetMapping("/")
    public String mainRedirect() {
        return "redirect:/api/v2/products";
    }

    @GetMapping( "/username")
    @ResponseBody
    public String currentUserName(Principal principal) {
        System.out.println(principal.getName());
        return principal.getName();
    }


}
