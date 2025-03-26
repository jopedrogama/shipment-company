package com.joaopedromattos.shipment_company.shipment.shipmentMethods;

import com.joaopedromattos.shipment_company.shipment.ShipmentPrediction;

public abstract class VehicleShipment {
    double distance;

    public VehicleShipment(
            double distance
            ) {
        this.distance = distance;
    }

    public abstract ShipmentPrediction estimateDelivery();
}
