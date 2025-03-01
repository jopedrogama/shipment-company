package com.joaopedromattos.shipment_company.customer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaopedromattos.shipment_company.customer.DTO.CustomerDTO;
import com.joaopedromattos.shipment_company.customer.DTO.Mapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    private CustomerService customerService;
    private Mapper mapper;

    public CustomerController(CustomerService customerService, Mapper mapper) {
        this.customerService = customerService;
        this.mapper = mapper;
    }

    @GetMapping()
    public String getCustomer(@RequestParam long id) {
        return customerService.getCustomerById(id);
    }
    

    @PostMapping()
    public String createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerModel customer = mapper.toModel(customerDTO);
        customerService.createCustomer(customer);
        return "OK";
    }
    
}
