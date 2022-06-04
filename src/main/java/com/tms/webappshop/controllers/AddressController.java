package com.tms.webappshop.controllers;


import com.tms.webappshop.dto.AddressDTO;
import com.tms.webappshop.exceptions.AddressException;
import com.tms.webappshop.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/addresses")
    public Set<AddressDTO> getAddresses() {
        return addressService.getAddresses();
    }

    @PostMapping("/addresses")
    public AddressDTO createAddress(@RequestBody AddressDTO addressDTO) {
        return addressService.createAddress(addressDTO);
    }

    @PutMapping("/addresses/{id}")
    public AddressDTO updateAddress(@PathVariable("id") Integer id, @RequestBody AddressDTO addressDTO) throws AddressException {
        return addressService.updateAddress(id, addressDTO);
    }

    @DeleteMapping("/addresses/{id}")
    public void deleteAddress(@PathVariable("id") Integer id) throws AddressException {
        addressService.deleteAddress(id);
    }

    @GetMapping("/addresses/{id}")
    public AddressDTO getAddressById(@PathVariable("id") Integer id) throws AddressException {
        return addressService.getAddressById(id);
    }

}
