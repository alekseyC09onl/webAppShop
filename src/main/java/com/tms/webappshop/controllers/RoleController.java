//package com.tms.webappshop.controllers;
//
//import com.tms.webappshop.dto.RoleDTO;
//import com.tms.webappshop.exceptions.RoleException;
//import com.tms.webappshop.service.RoleService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1")
//public class RoleController {
//
//    private final RoleService roleService;
//
//    @GetMapping("/roles")
//    public List<RoleDTO> getRoles() {
//        return roleService.getRoles();
//    }
//
//    @PostMapping("/roles")
//    public RoleDTO createRole(@RequestBody RoleDTO roleDTO) {
//        return roleService.createRole(roleDTO);
//    }
//
//    @PutMapping("/roles/{id}")
//    public RoleDTO updateRole(@PathVariable("id") Integer id, @RequestBody RoleDTO roleDTO) throws RoleException {
//        return roleService.updateRole(id, roleDTO);
//    }
//
//    @DeleteMapping("/roles/{id}")
//    public void deleteRole(@PathVariable("id") Integer id) throws RoleException {
//        roleService.deleteRole(id);
//    }
//
//    @GetMapping("/roles/{id}")
//    public RoleDTO getRoleById(@PathVariable("id") Integer id) throws RoleException {
//        return roleService.getRoleById(id);
//    }
//
//}
