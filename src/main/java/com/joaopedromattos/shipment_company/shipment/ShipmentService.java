package com.joaopedromattos.shipment_company.shipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.joaopedromattos.shipment_company.customer.CustomerModel;
import com.joaopedromattos.shipment_company.customer.CustomerRepository;
import com.joaopedromattos.shipment_company.customer.CustomerService;
import com.joaopedromattos.shipment_company.shipment.DTO.ShipmentDTO;
import com.joaopedromattos.shipment_company.shipment.shipmentMethods.ShipmentFactory;
import com.joaopedromattos.shipment_company.shipment.shipmentMethods.VehicleShipment;
import com.joaopedromattos.shipment_company.shipment.shipmentMethods.VehicleType;

@Service
public class ShipmentService {

    private ShipmentRepository shipmentRepository;
    private CustomerService customerService;

    public ShipmentService(ShipmentRepository shipmentRepository, CustomerService customerService) {
        this.shipmentRepository = shipmentRepository;
        this.customerService = customerService;
    }

    public void updateShipment(long id, String entity) {
        ShipmentModel shipment = this.getShipmentById(id);
        if (shipment == null) {
            throw new IllegalArgumentException("Shipment not found");
        }

        ShipmentModel shipmentToUpdate = ShipmentModel
            .builder()
            .id(shipment.getId())
            .distance(shipment.getDistance())
            .weight(shipment.getWeight())
            .vehicleType(shipment.getVehicleType())
            .price(shipment.getPrice())
            .estimateDelivery(shipment.getEstimateDelivery())
            .distance(shipment.getDistance())
            .build();
        
        this.shipmentRepository.save(shipmentToUpdate);
    }

    public List<ShipmentPrediction> getPriceEstimate(ShipmentDTO shipment) {
        List<ShipmentPrediction> predictions = new ArrayList<>();
        for (VehicleType vehicleType : VehicleType.values()) {
            VehicleShipment vehicle = ShipmentFactory.getVehicleShipment(vehicleType, shipment.getDistance());
            predictions.add(vehicle.estimateDelivery());
        }
       return predictions;
    }

    public void orderShipment(ShipmentModel shipment, String customerEmail) {
        CustomerModel customer = this.customerService.getCustomerByEmail(customerEmail);
        if(customer == null) {
           throw new IllegalArgumentException("Customer not found");
        }
        shipment.setCustomerId(customer.getId());

        VehicleShipment vehicle = ShipmentFactory.getVehicleShipment(shipment.getVehicleType(), shipment.getDistance());
        ShipmentPrediction prediction = vehicle.estimateDelivery();

        shipment.setEstimateDelivery(prediction.getEstimateDeliveryDate());
        shipment.setPrice(prediction.getShipmentPrice());
        this.shipmentRepository.save(shipment);
    }

    public ShipmentModel getShipmentById(long id) {
        Optional<ShipmentModel> shipment = this.shipmentRepository.findById(id);
        return shipment.orElse(null);
    }

    public String getShipmentByCustomerId(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'getShipmentByCustomerId'");
    }

    // private Boolean isShipmentVehicleValid(VehicleType vehicleType) {
    //     return vehicleType != null; // && VehicleType.values().contains(vehicleType);
    // }

}
