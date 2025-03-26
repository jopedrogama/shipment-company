package com.joaopedromattos.shipment_company.shipment;

import java.time.LocalDate;

import com.joaopedromattos.shipment_company.shipment.shipmentMethods.VehicleType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ShipmentPrediction {
    private VehicleType vehicleType;
    private LocalDate estimateDeliveryDate;
    private double shipmentPrice;
}
