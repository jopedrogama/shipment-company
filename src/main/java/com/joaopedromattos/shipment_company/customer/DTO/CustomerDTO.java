package com.joaopedromattos.shipment_company.customer.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDTO {

    private String firstName;
    private String lastName;
    private String email;
    private boolean receiveCommunication;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
}
