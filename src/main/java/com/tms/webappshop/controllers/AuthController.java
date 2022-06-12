package com.tms.webappshop.controllers;

import com.tms.webappshop.dto.UserDTO;
import com.tms.webappshop.entity.RoleEnum;
import com.tms.webappshop.service.CustomerService;
import com.tms.webappshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/v2")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final CustomerService customerService;

    @GetMapping("login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("logout")
    public String logout() {
        return "redirect:/api/v2/products";
    }

    @GetMapping("registration")
    public String registration(Model model) {
        model.addAttribute("userDTO", UserDTO.builder().build());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationUser(@ModelAttribute("userDTO") @Valid UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userDTO.setRole(RoleEnum.USER);
        userService.createUser(userDTO);
        return "success";
    }
}
