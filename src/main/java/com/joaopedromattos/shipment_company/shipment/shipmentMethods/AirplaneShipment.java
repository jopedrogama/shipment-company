package com.joaopedromattos.shipment_company.shipment.shipmentMethods;

import java.time.LocalDate;

import com.joaopedromattos.shipment_company.shipment.ShipmentPrediction;

public class AirplaneShipment extends VehicleShipment {

    private static final double TAX_FEE = 1.5;
    private static final int DELIVERY_TIME_DAYS = 2;
    private static final double VALUE_PER_KM = 1000;

    public AirplaneShipment(double distance) {
        super(distance);
    }

    @Override
    public ShipmentPrediction estimateDelivery() {
        if(this.distance < 100) {
            throw new IllegalArgumentException("Distance must be greater than 100 km");
        }
        return new ShipmentPrediction(VehicleType.AIRPLANE, LocalDate.now().plusDays(DELIVERY_TIME_DAYS),
                (this.distance * VALUE_PER_KM) * TAX_FEE);
    }
}
