package com.joaopedromattos.shipment_company.customer.DTO;

import org.springframework.stereotype.Component;

import com.joaopedromattos.shipment_company.customer.CustomerModel;

@Component
public class Mapper {
    public CustomerModel toModel(CustomerDTO dto) {
        return CustomerModel.builder()
            .firstName(dto.getFirstName())
            .lastName(dto.getLastName())
            .email(dto.getEmail())
            .recieveComunication(dto.isRecieveComunication())
            .birthDate(dto.getBirthDate())
            .build();
    }
}
