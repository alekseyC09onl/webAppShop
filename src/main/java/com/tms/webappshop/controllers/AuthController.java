package com.tms.webappshop.controllers;

import com.tms.webappshop.dto.UserDTO;
import com.tms.webappshop.entity.RoleEnum;
import com.tms.webappshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v2")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("registration")
    public String registration(Model model) {
        model.addAttribute("userDTO", UserDTO.builder().build());
        return "registration";
    }

    @PostMapping("/registration/user")
    public String registrationUser(@ModelAttribute("userDTO") UserDTO userDTO) {
        userDTO.setRole(RoleEnum.USER);
        userService.createUser(userDTO);
        return "success";
    }
}
