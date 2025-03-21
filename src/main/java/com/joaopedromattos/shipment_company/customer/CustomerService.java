package com.joaopedromattos.shipment_company.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository =customerRepository; 
    }
    

    public List<CustomerModel> getCustomers(){
        return customerRepository.findAll();
    }

    public CustomerModel createCustomer(CustomerModel customer) throws Exception{
        
        CustomerModel user = this.getCustomerByEmail(customer.getEmail());

        if (user != null) {
            throw new Exception("Email already registered");
        }
        
        CustomerModel a = customerRepository.save(customer);
        return a;
    }

    public CustomerModel getCustomerById(long id){
        Optional<CustomerModel> customer = customerRepository.findById(id);
        
        return customer.orElse(null);
    }

    public CustomerModel getCustomerByEmail(String email){
        Optional<CustomerModel> customer = customerRepository.findByEmail(email);
        return customer.orElse(null);
    }

    public void deleteCustomer(long id) {
        if (this.getCustomerById(id) != null) {
            this.customerRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Customer not found");
        }
    }

    public CustomerModel updateCustomer(CustomerModel customer) {
        CustomerModel customerToUpdate = this.getCustomerById(customer.getId());
        if (customerToUpdate == null) {
            throw new IllegalArgumentException("Customer not found");
        }
        customerToUpdate.setFirstName(customer.getFirstName());
        customerToUpdate.setLastName(customer.getLastName());
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setRecieveComunication(customer.isRecieveComunication());
        customerToUpdate.setBirthDate(customer.getBirthDate());
        return customerRepository.save(customerToUpdate);
    }
}
