package com.joaopedromattos.shipment_company.shipment;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.joaopedromattos.shipment_company.shipment.shipmentMethods.VehicleType;

public class ShipmentService {

    private ShipmentRepository shipmentRepository;

    public ShipmentService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public void updateShipment(long id, String entity) {
        ShipmentModel shipment = this.getShipmentById(id);
        if (shipment == null) {
            throw new IllegalArgumentException("Shipment not found");
        }
        shipment.setDistance(id);
        shipment.setWeight(0);
        shipment.setVehicleType(VehicleType.CAR);
        shipment.setPricePerKm(0);
        shipment.setPricePerKm(0);
        shipment.setEstimateDelivery(null);
        shipment.setDistance(10);
        this.shipmentRepository.save(shipment);
    }

    public void getPriceEstimate(String type) throws Exception {
        if (this.isShipmentVehicleValid(type)) {
            throw new Exception("Invalid vehicle type for this package or shipment");
        }
        throw new UnsupportedOperationException("Unimplemented method 'getPriceEstimate'");
    }

    public void orderShipment(String str) {
        throw new UnsupportedOperationException("Unimplemented method 'orderShipment'");
    }

    public ShipmentModel getShipmentById(long id) {
        Optional<ShipmentModel> shipment = this.shipmentRepository.findById(id);
        return shipment.orElse(null);
    }

    public String getShipmentByCustomerId(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'getShipmentByCustomerId'");
    }

    private boolean isShipmentVehicleValid(String type) {
        throw new UnsupportedOperationException("Unimplemented method 'isShipmentVehicleValid'");
    }

}
