package com.joaopedromattos.shipment_company.shipment.DTO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.joaopedromattos.shipment_company.shipment.ShipmentModel;
import com.joaopedromattos.shipment_company.shipment.ShipmentPrediction;
import com.joaopedromattos.shipment_company.shipment.ShipmentStatus;

@Component
public class Mapper {

    public static ShipmentModel toModel(ShipmentDTO shipmentDto) {
        return ShipmentModel.builder()
            .distance(shipmentDto.getDistance())
            .vehicleType(shipmentDto.getVehicleType())
            .weight(shipmentDto.getWeight())
            .status(shipmentDto.getStatus() != null ? shipmentDto.getStatus() : ShipmentStatus.PENDING)
            .build();
    }

    public static ShipmentEstimationsDTO toEstimationsDTO(List<ShipmentPrediction> predictions) {
        return new ShipmentEstimationsDTO(predictions);
    }

}
