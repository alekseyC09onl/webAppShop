package com.tms.webappshop.mapper;

import com.tms.webappshop.common.Helpers;
import com.tms.webappshop.dto.UserDTO;
import com.tms.webappshop.entity.Customer;

public class UserDTOCustomerMapper {
    public static Customer mapToCustomer(UserDTO userDTO) {
        return Customer.builder()
                .email(userDTO.getEmail())
                .firstName(Helpers.toUpFirstSymbol(userDTO.getFirstName()))
                .lastName(Helpers.toUpFirstSymbol(userDTO.getLastName()))
                .phoneNumber(userDTO.getPhoneNumber())
                .build();
    }
}
