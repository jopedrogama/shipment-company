package com.joaopedromattos.shipment_company.shipment.shipmentMethods;

import org.springframework.http.HttpStatus;

import com.joaopedromattos.shipment_company.exceptions.ApplicationException;

public class ShipmentFactory {
    public static VehicleShipment getVehicleShipment(VehicleType vehicleType, double distance) {
        switch (vehicleType) {
            case CAR:
                return new CarShipment(distance);
            case AIRPLANE:
                return new AirplaneShipment(distance);
            default:
                throw new ApplicationException("Invalid vehicle type", HttpStatus.BAD_REQUEST);
        }
    }
}
