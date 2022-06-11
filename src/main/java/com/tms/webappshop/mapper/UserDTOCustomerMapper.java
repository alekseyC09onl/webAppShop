package com.tms.webappshop.mapper;

import com.tms.webappshop.dto.UserDTO;
import com.tms.webappshop.entity.Customer;

public class UserDTOCustomerMapper {
    public static Customer mapToCustomer(UserDTO userDTO) {
        return Customer.builder()
                .email(userDTO.getEmail())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .phoneNumber(userDTO.getPhoneNumber())
                .build();
    }
}
