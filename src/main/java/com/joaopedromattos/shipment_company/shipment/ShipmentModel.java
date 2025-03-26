package com.joaopedromattos.shipment_company.shipment;
import java.time.LocalDate;

import com.joaopedromattos.shipment_company.customer.CustomerModel;
import com.joaopedromattos.shipment_company.shipment.shipmentMethods.VehicleType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "shipment")
public class ShipmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private double distance;

    @NotNull
    private double price;

    @NotNull
    private double weight;

    @NotNull
    private LocalDate estimateDelivery;

    @NotNull
    private VehicleType vehicleType;

    @NotNull
    @Column(length = 32, columnDefinition = "varchar(32) default 'PENDING'")
    @Enumerated(value = EnumType.STRING)
    private ShipmentStatus status;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;
}
