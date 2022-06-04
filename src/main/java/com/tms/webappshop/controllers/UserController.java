package com.tms.webappshop.controllers;

import com.tms.webappshop.dto.UserDTO;
import com.tms.webappshop.exceptions.UserException;
import com.tms.webappshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserDTO> getUser() {
        return userService.getUsers();
    }

    @PostMapping("/users")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PutMapping("/users/{id}")
    public UserDTO updateUser(@PathVariable("id") Integer id, @RequestBody UserDTO userDTO) throws UserException {
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteUser(@PathVariable("id") Integer id) throws UserException {
        return userService.deleteUser(id);
    }

    @GetMapping("/users/{id}")
    public UserDTO getUserById(@PathVariable("id") Integer id) throws UserException {
        return userService.getUserById(id);
    }

}