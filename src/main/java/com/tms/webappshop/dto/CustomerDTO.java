package com.tms.webappshop.dto;

import com.tms.webappshop.entity.Address;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Address address;
}

