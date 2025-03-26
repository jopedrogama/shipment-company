package com.joaopedromattos.shipment_company.shipment.shipmentMethods;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import com.joaopedromattos.shipment_company.shipment.ShipmentPrediction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarShipmentTest {

    private static final double TEST_DISTANCE = 100.0;
    private static final double DELTA = 0.001; // For double comparisons
    private CarShipment carShipment;

    @BeforeEach
    void setUp() {
        carShipment = new CarShipment(TEST_DISTANCE);
    }

    @Test
    void constructor_shouldSetDistance() {
        assertEquals(TEST_DISTANCE, 100, DELTA);
    }

    @Test
    void estimateDelivery_shouldReturnCarType() {
        ShipmentPrediction prediction = carShipment.estimateDelivery();
        assertEquals(VehicleType.CAR, prediction.getVehicleType());
    }

    @Test
    void estimateDelivery_shouldReturnCorrectDeliveryDate() {
        LocalDate expectedDate = LocalDate.now().plusDays(15);
        ShipmentPrediction prediction = carShipment.estimateDelivery();
        assertEquals(expectedDate, prediction.getEstimateDeliveryDate());
    }

    @ParameterizedTest // This approach has the idea of not re writiting the code for each scenario
    @ValueSource(doubles = {0, 50, 100, 200})
    void estimateDelivery_shouldCalculateCorrectPrice(double distance) {
        CarShipment shipment = new CarShipment(distance);
        double expectedPrice = (distance * 1000) * 1.2 + 2;
        ShipmentPrediction prediction = shipment.estimateDelivery();
        assertEquals(expectedPrice, prediction.getShipmentPrice(), DELTA);
    }
}