package com.tms.webappshop.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO {

    private String city;

    private String street;

    private String houseNumber;

    private String flatNumber;

    private Integer level;

}
