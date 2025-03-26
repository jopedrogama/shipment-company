package com.joaopedromattos.shipment_company.shipment.DTO;

import java.util.List;
import org.springframework.stereotype.Component;

import com.joaopedromattos.shipment_company.shipment.ShipmentPrediction;

import lombok.AllArgsConstructor;
@Component
@AllArgsConstructor
public class ShipmentEstimationsDTO {
    List<ShipmentPrediction> estimates;
}
