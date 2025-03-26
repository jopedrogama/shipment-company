package com.joaopedromattos.shipment_company.shipment.shipmentMethods;

import java.time.LocalDate;

import com.joaopedromattos.shipment_company.shipment.ShipmentPrediction;

public class CarShipment extends VehicleShipment{

    private static final double TAX_FEE = 1.2;
    private static final double DELIVERY_DRIVER_TIP = 2;
    private static final int DELIVERY_TIME_DAYS = 15;
    private static final double VALUE_PER_KM = 1000;

    public CarShipment(double distance) {
        super(distance);
    }

    @Override
    public ShipmentPrediction estimateDelivery() {
        if(this.distance < 0) {
            throw new IllegalArgumentException("Distance must be greater than 0 km");
        }
        return new ShipmentPrediction(VehicleType.CAR, LocalDate.now().plusDays(DELIVERY_TIME_DAYS),
        (this.distance * VALUE_PER_KM) * TAX_FEE + DELIVERY_DRIVER_TIP);
    }
    
}

