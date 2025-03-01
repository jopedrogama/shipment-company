package com.joaopedromattos.shipment_company.customer;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customers")
public class CustomerModel {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Column(unique = true)
    private String email;
    
    @Column()
    @NotNull
    private boolean recieveComunication;

    @Column()
    @NotNull
    private LocalDate birthDate;
}
