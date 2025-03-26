package com.joaopedromattos.shipment_company.shipment.shipmentMethods;

public class ShipmentFactory {
    public static VehicleShipment getVehicleShipment(VehicleType vehicleType, double distance) {
        switch (vehicleType) {
            case CAR:
                return new CarShipment(distance);
            case AIRPLANE:
                return new AirplaneShipment(distance);
            default:
                throw new IllegalArgumentException("Invalid vehicle type");
        }
    }
}
