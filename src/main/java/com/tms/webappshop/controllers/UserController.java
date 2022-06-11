package com.tms.webappshop.controllers;

import com.tms.webappshop.dto.UserDTO;
import com.tms.webappshop.entity.RoleEnum;
import com.tms.webappshop.exceptions.ProductException;
import com.tms.webappshop.exceptions.UserException;
import com.tms.webappshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v2")
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserDTO> getUser() {
        return userService.getUsers();
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute("userDTO") UserDTO userDTO) {
        userService.createUser(userDTO);
        return "redirect:/api/v2/admin/users";

    }

    @PutMapping("/admin/users/{id}")
    public String adminUpdateUser(@PathVariable("id") Integer id, @ModelAttribute("userDTO") UserDTO userDTO) throws UserException {
        userService.updateUser(userDTO);
        return "redirect:/api/v2/admin/users";
    }

    @DeleteMapping("/admin/users/{id}")
    public String deleteUser(@PathVariable("id") Integer id) throws UserException {
        userService.deleteUser(id);
        return "redirect:/api/v2/admin/users";
    }

    @GetMapping("/users/{id}")
    public UserDTO getUserById(@PathVariable("id") Integer id) throws UserException {
        return userService.getUserById(id);
    }

    @GetMapping("/admin/users/new")
    public String toFormCreateUser(Model model) {
        model.addAttribute("userDTO", UserDTO.builder().build());
        model.addAttribute("roleAdmin", RoleEnum.ADMIN);
        model.addAttribute("roleUser", RoleEnum.USER);
        return "admin_add_user";
    }

    @GetMapping("/admin/users")
    public String adminUsers(Model model) {
        model.addAttribute("userDTOList", userService.getUsers());
        return "admin_users";
    }

    @GetMapping("/admin/users/update/{id}")
    public String redirectUpdateUsersMethod(@PathVariable("id") Integer id, Model model) throws UserException {
        model.addAttribute("userDTO", userService.getUserById(id));
        return "admin_update_user";
    }

    @GetMapping("/users/edit")
    public String editProfile(Model model, Principal principal) throws UserException {
        model.addAttribute("userDTO", userService.getUserDTOByEmail(principal.getName()));
        return "update_user";
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable("id") Integer id, @ModelAttribute("userDTO") UserDTO userDTO) throws UserException {
        userDTO.setRole(RoleEnum.USER);
        userService.updateUser(userDTO);
        return "redirect:/api/v2/products";
    }
}