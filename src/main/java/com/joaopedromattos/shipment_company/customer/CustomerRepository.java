package com.joaopedromattos.shipment_company.customer;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {}
