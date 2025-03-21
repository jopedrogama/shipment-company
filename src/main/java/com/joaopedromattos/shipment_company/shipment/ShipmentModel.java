package com.joaopedromattos.shipment_company.shipment;

import java.sql.Date;

import com.joaopedromattos.shipment_company.customer.CustomerModel;
import com.joaopedromattos.shipment_company.shipment.shipmentMethods.VehicleType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
@Table(name = "shipment")
public class ShipmentModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private double distance;

    @NotNull
    private double pricePerKm;

    @NotNull
    private double weight;

    @NotNull
    private Date estimateDelivery;

    @NotNull
    private VehicleType vehicleType;

    @NotNull
    @ManyToOne(targetEntity = CustomerModel.class)
    private long customerId;
}
