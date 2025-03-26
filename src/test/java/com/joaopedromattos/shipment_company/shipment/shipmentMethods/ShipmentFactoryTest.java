package com.joaopedromattos.shipment_company.shipment.shipmentMethods;

import static org.junit.jupiter.api.Assertions.*;

import com.joaopedromattos.shipment_company.exceptions.ApplicationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
class ShipmentFactoryTest {
    
    private double testDistance = 100.0;

    @Test
    void getVehicleShipment_shouldReturnCarShipment_whenVehicleTypeIsCar() {

        
        VehicleShipment result = ShipmentFactory.getVehicleShipment(VehicleType.CAR, testDistance);
        assertTrue(result instanceof CarShipment);
    }

    @Test
    void getVehicleShipment_shouldReturnAirplaneShipment_whenVehicleTypeIsAirplane() {

        VehicleShipment result = ShipmentFactory.getVehicleShipment(VehicleType.AIRPLANE, testDistance);
        assertNotNull(result);
        assertTrue(result instanceof AirplaneShipment);
    }

    @Test
    void getVehicleShipment_shouldThrowApplicationException_whenVehicleTypeIsInvalid() {
        ApplicationException exception = assertThrows(ApplicationException.class, 
            () -> ShipmentFactory.getVehicleShipment(VehicleType.MOTORBIKE, testDistance));
        
        assertEquals("Invalid vehicle type", exception.getMessage());
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
    }

}
