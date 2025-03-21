package com.joaopedromattos.shipment_company.shipment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    private ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @GetMapping("/customer/{id}")
    public String getShipmentByCustomerId(@PathVariable int id) {
        return this.shipmentService.getShipmentByCustomerId(id);
    }

    @GetMapping("/{id}")
    public String getShipmentById(@PathVariable int id) {
        return this.shipmentService.getShipmentById(id);
    }
    
    @PostMapping
    public String orderShipment(@RequestBody String str) {
        this.shipmentService.orderShipment(str);
        return str;
    }

    @GetMapping("/price-estimate")
    public String getPriceEstimate(@RequestBody String type) {
        this.shipmentService.getPriceEstimate(type);
        return type;
    }

    @PutMapping("/{id}")
    public String putMethodName(@PathVariable String id, @RequestBody String entity) {
        this.shipmentService.updateShipment(id, entity);
        return entity;
    }
    
}
