package com.joaopedromattos.shipment_company.customer;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {
    
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository =customerRepository; 
    }
    
    @Transactional
    public void createCustomer(CustomerModel customer){
        customerRepository.save(customer);
    }

    public String getCustomerById(long id){
        customerRepository.findById(id);
        return "OK";   
    }
}
