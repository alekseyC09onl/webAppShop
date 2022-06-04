package com.tms.webappshop.service;

import com.tms.webappshop.dto.AddressDTO;
import com.tms.webappshop.entity.Address;
import com.tms.webappshop.exceptions.AddressException;
import com.tms.webappshop.mapper.AddressMapper;
import com.tms.webappshop.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public Set<AddressDTO> getAddresses() {
        return addressRepository.findAll().stream()
                .map(AddressMapper::mapToDTO)
                .collect(Collectors.toSet());
    }

    public AddressDTO createAddress(AddressDTO addressDTO) {
        addressRepository.save(AddressMapper.mapToEntity(addressDTO));
        return addressDTO;
    }

    public AddressDTO updateAddress(Integer id, AddressDTO addressDTO) throws AddressException {
        if (addressRepository.findById(id).isPresent()) {
            Address address = AddressMapper.mapToEntity(addressDTO);
            address.setId(id);
            addressRepository.save(address);
            return AddressMapper.mapToDTO(address);
        } else {
            throw new AddressException(("Address with id: " + id + " was not found"));
        }
    }

    public void deleteAddress(Integer id) throws AddressException {
        if (addressRepository.findById(id).isPresent()) {
            addressRepository.deleteById(id);
        } else {
            throw new AddressException(("Address with id: " + id + " was not found"));
        }
    }

    public AddressDTO getAddressById(Integer id) throws AddressException {
        if (addressRepository.findById(id).isPresent()) {
            return AddressMapper.mapToDTO(addressRepository.getById(id));
        } else {
            throw new AddressException(("Address with id: " + id + " was not found"));
        }
    }
}
