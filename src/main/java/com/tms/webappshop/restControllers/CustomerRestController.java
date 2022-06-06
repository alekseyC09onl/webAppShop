package com.tms.webappshop.restControllers;

import com.tms.webappshop.dto.CustomerDTO;
import com.tms.webappshop.exceptions.CustomerException;
import com.tms.webappshop.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CustomerRestController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public Set<CustomerDTO> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping("/customers")
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.createCustomer(customerDTO);
    }

    @PutMapping("/customers/{id}")
    public CustomerDTO updateCustomer(@PathVariable("id") Integer id, @RequestBody CustomerDTO customerDTO) throws CustomerException {
        return customerService.updateCustomer(id, customerDTO);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id) throws CustomerException {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomerById(@PathVariable("id") Integer id) throws CustomerException {
        return customerService.getCustomerById(id);
    }
}
