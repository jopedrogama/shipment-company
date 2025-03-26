package com.joaopedromattos.shipment_company.shipment.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.joaopedromattos.shipment_company.customer.CustomerModel;
import com.joaopedromattos.shipment_company.shipment.shipmentMethods.VehicleType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentDTO {

    private String customerEmail;
    private double distance;
    private double weight;
    private VehicleType vehicleType;

}
