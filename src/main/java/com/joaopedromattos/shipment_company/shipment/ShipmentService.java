package com.joaopedromattos.shipment_company.shipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.joaopedromattos.shipment_company.customer.CustomerModel;
import com.joaopedromattos.shipment_company.customer.CustomerService;
import com.joaopedromattos.shipment_company.exceptions.ApplicationException;
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

    public ShipmentModel updateShipment(Long id, ShipmentModel shipmentModel) {
        ShipmentModel shipment = this.getShipmentById(id);
        if (shipment == null) {
            throw new ApplicationException("Shipment not found", HttpStatus.NOT_FOUND);
        }
        shipment.setStatus(shipmentModel.getStatus());
        
        return this.shipmentRepository.save(shipment);
    }

    public List<ShipmentPrediction> getPriceEstimate(ShipmentModel shipment) {
        
        this.validateShipment(shipment);
        
        List<ShipmentPrediction> predictions = new ArrayList<>();
        for (VehicleType vehicleType : VehicleType.values()) {
            try {
                VehicleShipment vehicle = ShipmentFactory.getVehicleShipment(vehicleType, shipment.getDistance());
                predictions.add(vehicle.estimateDelivery());
            } catch (Exception e) {
                System.out.println("Error getting price estimate for vehicle type: " + vehicleType);
            }
        }
        return predictions;
    }

    public ShipmentModel orderShipment(ShipmentModel shipment, String customerEmail) {

        CustomerModel customer = this.customerService.getCustomerByEmail(customerEmail);
        if (customer == null) {
            throw new ApplicationException("Customer not found", HttpStatus.NOT_FOUND);
        }

        this.validateShipment(shipment);

        shipment.setCustomer(customer);

        // try {
            VehicleShipment vehicle = ShipmentFactory.getVehicleShipment(shipment.getVehicleType(), shipment.getDistance());
            ShipmentPrediction prediction = vehicle.estimateDelivery();

            shipment.setEstimateDelivery(prediction.getEstimateDeliveryDate());
            shipment.setPrice(prediction.getShipmentPrice());
            return this.shipmentRepository.save(shipment);
        // } catch (Exception e) {
        //     throw new ApplicationException("Error processing shipment: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        // }
    }

    public ShipmentModel getShipmentById(Long id) throws ApplicationException {
        Optional<ShipmentModel> shipment = this.shipmentRepository.findById(id);
        return shipment.orElseThrow(() -> new ApplicationException("Shipment id not found", HttpStatus.NOT_FOUND));
    }

    public List<ShipmentModel> getShipmentByCustomerId(Long id) {
        List<ShipmentModel> shipments = this.shipmentRepository.findByCustomerId(id);
        return shipments;
    }

    public List<ShipmentModel> getShipments() {
        return this.shipmentRepository.findAll();
    }

    public void deleteShipment(Long id) {
        this.getShipmentById(id);
        try {
            this.shipmentRepository.deleteById(id);
        } catch (Exception e) {
            throw new ApplicationException("Error deleting the shipment: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    private void validateShipment(ShipmentModel shipment) {
        if (shipment.getDistance() <= 0) {
            throw new ApplicationException("Distance must be greater than 0", HttpStatus.BAD_REQUEST);
        }

        if (shipment.getWeight() <= 0) {
            throw new ApplicationException("Weight must be greater than 0", HttpStatus.BAD_REQUEST);
        }
    }
}
