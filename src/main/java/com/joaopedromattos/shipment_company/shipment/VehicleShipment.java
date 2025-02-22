package com.joaopedromattos.shipment_company.shipment;

public class VehicleShipment {
    int valuePerKm;
    double distance;

    VehicleShipment(double distance){
        this.distance = distance;
    }

    public double estimateDelivery(){
        return this.distance * this.valuePerKm;
    }
}
