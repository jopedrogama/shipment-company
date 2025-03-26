package com.joaopedromattos.shipment_company.shipment;
import java.time.LocalDate;

import com.joaopedromattos.shipment_company.customer.CustomerModel;
import com.joaopedromattos.shipment_company.shipment.shipmentMethods.VehicleType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "shipment")
public class ShipmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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
    @ManyToOne(targetEntity = CustomerModel.class)
    private long customerId;
}
