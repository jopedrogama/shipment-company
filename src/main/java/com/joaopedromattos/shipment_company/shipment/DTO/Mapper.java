package com.joaopedromattos.shipment_company.shipment.DTO;

import org.springframework.stereotype.Component;

import com.joaopedromattos.shipment_company.shipment.ShipmentModel;

@Component
public class Mapper {

    public static ShipmentModel toModel(ShipmentDTO shipmentDto) {
        return new ShipmentModel(0, 0, 0, 0, null, null, 0);
    }

}
