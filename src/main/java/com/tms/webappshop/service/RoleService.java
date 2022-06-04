//package com.tms.webappshop.service;
//
//import com.tms.webappshop.dto.RoleDTO;
//import com.tms.webappshop.entity.Role;
//import com.tms.webappshop.exceptions.RoleException;
//import com.tms.webappshop.mapper.RoleMapper;
//import com.tms.webappshop.repository.RoleRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class RoleService {
//
//    private final RoleRepository roleRepository;
//
//    public List<RoleDTO> getRoles() {
//        return roleRepository.findAll().stream()
//                .map(RoleMapper::mapToDTO)
//                .collect(Collectors.toList());
//    }
//
//    public RoleDTO createRole(RoleDTO roleDTO) {
//        roleRepository.save(RoleMapper.mapToEntity(roleDTO));
//        return roleDTO;
//    }
//
//    public RoleDTO updateRole(Integer id, RoleDTO roleDTO) throws RoleException {
//        if (roleRepository.findById(id).isPresent()) {
//            Role role = RoleMapper.mapToEntity(roleDTO);
//            role.setId(id);
//            roleRepository.save(role);
//            return RoleMapper.mapToDTO(role);
//        } else {
//            throw new RoleException(("Role with id: " + id + " was not found"));
//        }
//    }
//
//    public void deleteRole(Integer id) throws RoleException {
//        if (roleRepository.findById(id).isPresent()) {
////            Role role = roleRepository.getById(id);
//            roleRepository.deleteById(id);
////            return RoleMapper.mapToDTO(role);
//        } else {
//            throw new RoleException(("Role with id: " + id + " was not found"));
//        }
//    }
//
//    public RoleDTO getRoleById(Integer id) throws RoleException {
//        if (roleRepository.findById(id).isPresent()) {
//            return RoleMapper.mapToDTO(roleRepository.getById(id));
//        } else {
//            throw new RoleException(("Role with id: " + id + " was not found"));
//        }
//    }
//}
