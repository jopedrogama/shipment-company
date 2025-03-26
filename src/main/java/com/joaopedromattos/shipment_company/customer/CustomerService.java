package com.joaopedromattos.shipment_company.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.joaopedromattos.shipment_company.exceptions.ApplicationException;

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
            throw new ApplicationException("Email already registered", HttpStatus.BAD_REQUEST);
        }
        
        CustomerModel a = customerRepository.save(customer);
        return a;
    }

    public CustomerModel getCustomerById(Long id) throws ApplicationException{
     
            Optional<CustomerModel> customer = customerRepository.findById(id);
            return customer.orElseThrow(() -> new ApplicationException("User Id not found", HttpStatus.NOT_FOUND));
    }

    public CustomerModel getCustomerByEmail(String email){
        Optional<CustomerModel> customer = customerRepository.findByEmail(email);
        return customer.orElse(null);
    }

    public void deleteCustomer(Long id) throws ApplicationException {
        this.getCustomerById(id);
        try{
            this.customerRepository.deleteById(id); 
        }catch(Exception e){
            throw new ApplicationException("Error deleting the data", HttpStatus.BAD_REQUEST);
        }
    }

    public CustomerModel updateCustomer(CustomerModel customer, Long id) throws ApplicationException {
        CustomerModel customerToUpdate = this.getCustomerById(id);

        try{
            customerToUpdate.setFirstName(customer.getFirstName());
            customerToUpdate.setLastName(customer.getLastName());
            customerToUpdate.setEmail(customer.getEmail());
            customerToUpdate.setReceiveCommunication(customer.isReceiveCommunication());
            customerToUpdate.setBirthDate(customer.getBirthDate());
        }catch(Exception e){
            throw new ApplicationException("Error defining new data params", HttpStatus.BAD_REQUEST);
        }

        try{
            return customerRepository.save(customerToUpdate);
        }catch(Exception e){
            throw new ApplicationException("Error updating the data", HttpStatus.BAD_REQUEST);
        }
    }
}
