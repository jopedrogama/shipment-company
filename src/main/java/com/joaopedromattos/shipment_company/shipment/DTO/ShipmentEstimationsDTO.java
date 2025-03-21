package com.joaopedromattos.shipment_company.shipment.DTO;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ShipmentEstimationsDTO {
    List<ShipmentPredictionDTO> estimates;
}
