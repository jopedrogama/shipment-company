package com.joaopedromattos.shipment_company.shipment.costCenter;

import com.joaopedromattos.shipment_company.shipment.ShipmentModel;
import com.joaopedromattos.shipment_company.shipment.shipmentMethods.VehicleShipment;
import com.joaopedromattos.shipment_company.shipment.shipmentMethods.VehicleType;

public class CostCenterService {

    public double calculatePrice(ShipmentModel shipment) {
        VehicleType vehicleType = shipment.getVehicleType();
        VehicleShipment vehicle;
        if (vehicleType)
            return vehicle.estimateDelivery();
    }
}
