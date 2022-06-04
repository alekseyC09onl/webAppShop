package com.tms.webappshop.mapper;

import com.tms.webappshop.dto.AddressDTO;
import com.tms.webappshop.entity.Address;

public class AddressMapper {

    public static AddressDTO mapToDTO(Address address) {
        return AddressDTO.builder()
                .city(address.getCity())
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .level(address.getLevel())
                .flatNumber(address.getFlatNumber())
                .build();
    }

    public static Address mapToEntity(AddressDTO addressDTO) {
        return Address.builder()
                .city(addressDTO.getCity())
                .street(addressDTO.getStreet())
                .houseNumber(addressDTO.getHouseNumber())
                .level(addressDTO.getLevel())
                .flatNumber(addressDTO.getFlatNumber())
                .build();
    }
}
