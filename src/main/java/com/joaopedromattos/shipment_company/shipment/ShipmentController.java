package com.joaopedromattos.shipment_company.shipment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaopedromattos.shipment_company.shipment.DTO.ShipmentEstimationsDTO;

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
    public ResponseEntity<ShipmentModel> getShipmentById(@PathVariable int id) {
        ShipmentModel shipment = this.shipmentService.getShipmentById(id);
        return new ResponseEntity<>(shipment, HttpStatus.OK);
    }

    @PostMapping
    public String orderShipment(@RequestBody String str) {
        this.shipmentService.orderShipment(str);
        return str;
    }

    @GetMapping("/estimations")
    public ResponseEntity<ShipmentEstimationsDTO> getShipmentEstimationsDTO(@RequestBody String type) {
        this.shipmentService.getPriceEstimate(type);
        return new ResponseEntity<>();
        ;
    }

    @PutMapping("/{id}")
    public String putMethodName(@PathVariable String id, @RequestBody String entity) {
        this.shipmentService.updateShipment(id, entity);
        return entity;
    }

}
