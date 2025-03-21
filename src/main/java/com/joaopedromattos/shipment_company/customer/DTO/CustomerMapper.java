package com.joaopedromattos.shipment_company.customer.DTO;

import org.springframework.stereotype.Component;

import com.joaopedromattos.shipment_company.customer.CustomerModel;

@Component
public class CustomerMapper {
    public static CustomerModel toModel(CustomerDTO dto) {
        return CustomerModel.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .recieveComunication(dto.isRecieveComunication())
                .birthDate(dto.getBirthDate())
                .build();
    }

    public static CustomerDTO toDTO(CustomerModel model) {
        return CustomerDTO.builder()
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .email(model.getEmail())
                .recieveComunication(model.isRecieveComunication())
                .birthDate(model.getBirthDate())
                .build();
    }
}
