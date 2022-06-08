package com.tms.webappshop.mapper;

import com.tms.webappshop.common.Helpers;
import com.tms.webappshop.dto.UserDTO;
import com.tms.webappshop.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public class UserMapper {

    public static UserDTO mapToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName((user.getFirstName()))
                .lastName((user.getLastName()))
//                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole())
                .build();
    }

    public static User mapToEntity(UserDTO userDTO) {
        return User.builder()
                .email(userDTO.getEmail())
                .firstName((userDTO.getFirstName()))
                .lastName((userDTO.getLastName()))
                .password(Helpers.passwordEncoder().encode(userDTO.getPassword()))
                .phoneNumber(userDTO.getPhoneNumber())
                .role(userDTO.getRole())
                .build();
    }

    public static UserDetails mapToUserDetails(User user) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getRole().getAuthorities())
                .build();
    }

}
