package com.tms.webappshop.service;

import com.tms.webappshop.dto.CustomerDTO;
import com.tms.webappshop.entity.Customer;
import com.tms.webappshop.exceptions.CustomerException;
import com.tms.webappshop.mapper.CustomerMapper;
import com.tms.webappshop.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Set<CustomerDTO> getCustomers() {
        return customerRepository.findAll().stream()
                .map(CustomerMapper::mapToDTO)
                .collect(Collectors.toSet());
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        customerRepository.save(CustomerMapper.mapToEntity(customerDTO));
        return customerDTO;
    }

    public CustomerDTO updateCustomer(Integer id, CustomerDTO customerDTO) throws CustomerException {
        if (customerRepository.findById(id).isPresent()) {
            Customer customer = CustomerMapper.mapToEntity(customerDTO);
            customer.setId(id);
            customerRepository.save(customer);
            return CustomerMapper.mapToDTO(customer);
        } else {
            throw new CustomerException(("Customer with id: " + id + " was not found"));
        }
    }

    public void deleteCustomer(Integer id) throws CustomerException {
        if (customerRepository.findById(id).isPresent()) {
            customerRepository.deleteById(id);
        } else {
            throw new CustomerException(("Customer with id: " + id + " was not found"));
        }
    }

    public CustomerDTO getCustomerById(Integer id) throws CustomerException {
        if (customerRepository.findById(id).isPresent()) {
            return CustomerMapper.mapToDTO(customerRepository.getById(id));
        } else {
            throw new CustomerException(("Customer with id: " + id + " was not found"));
        }
    }
}
