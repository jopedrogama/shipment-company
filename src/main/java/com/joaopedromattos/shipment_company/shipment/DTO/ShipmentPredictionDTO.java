package com.joaopedromattos.shipment_company.shipment.DTO;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.joaopedromattos.shipment_company.shipment.shipmentMethods.VehicleType;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ShipmentPredictionDTO {
    private VehicleType vehicleType;
    private LocalDate estimateDeliveryDate;
    private double shipmentPrice;
}
