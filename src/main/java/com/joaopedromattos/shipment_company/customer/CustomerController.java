package com.joaopedromattos.shipment_company.customer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaopedromattos.shipment_company.customer.DTO.CustomerDTO;
import com.joaopedromattos.shipment_company.customer.DTO.Mapper;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    private CustomerService customerService;
    private Mapper mapper;

    public CustomerController(CustomerService customerService, Mapper mapper) {
        this.customerService = customerService;
        this.mapper = mapper;
    }

    @GetMapping()
    public ResponseEntity<List<CustomerModel>> getCustomers() {
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerModel> getCustomers(@PathVariable long id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK) ;
    }

    @PostMapping()
    public ResponseEntity<CustomerModel> createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerModel customer = mapper.toModel(customerDTO);
        try {
            CustomerModel response = customerService.createCustomer(customer);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
