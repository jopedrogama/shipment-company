package com.joaopedromattos.shipment_company.shipment.shipmentMethods;

import com.joaopedromattos.shipment_company.shipment.DTO.ShipmentPredictionDTO;

public class VehicleShipment {
    int valuePerKm;
    double distance;
    double taxFee;

    public VehicleShipment(int valuePerKm,
            double distance,
            double taxFee) {
        this.distance = distance;
        this.taxFee = taxFee;
        this.valuePerKm = valuePerKm;
    }

    public ShipmentPredictionDTO estimateDelivery() {
    }
}
