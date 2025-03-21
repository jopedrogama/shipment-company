package com.joaopedromattos.shipment_company.shipment.shipmentMethods;

import java.time.LocalDate;

import com.joaopedromattos.shipment_company.shipment.DTO.ShipmentPredictionDTO;

public class AirplaneShipment extends VehicleShipment {

    @Override
    public ShipmentPredictionDTO estimateDelivery() {
        return new ShipmentPredictionDTO(VehicleType.AIRPLANE, LocalDate.now().plusDays(3),
                (this.distance * this.valuePerKm) * this.taxFee);
    }
}
