package com.joaopedromattos.shipment_company.shipment;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaopedromattos.shipment_company.shipment.DTO.Mapper;
import com.joaopedromattos.shipment_company.shipment.DTO.ShipmentDTO;
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
    public ResponseEntity<List<ShipmentModel>> getShipmentByCustomerId(@PathVariable Long id) {
        return new ResponseEntity<>(this.shipmentService.getShipmentByCustomerId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShipmentModel> getShipmentById(@PathVariable Long id) {
        ShipmentModel shipment = this.shipmentService.getShipmentById(id);
        return new ResponseEntity<>(shipment, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ShipmentModel>> getShipments() {
        return new ResponseEntity<>(this.shipmentService.getShipments(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShipmentModel> orderShipment(@RequestBody ShipmentDTO shipmentDto) {
        ShipmentModel shipment = Mapper.toModel(shipmentDto);
        ShipmentModel createdShipment = this.shipmentService.orderShipment(shipment, shipmentDto.getCustomerEmail());
        return new ResponseEntity<>(createdShipment, HttpStatus.CREATED);
    }

    @GetMapping("/estimation")
    public ResponseEntity<ShipmentEstimationsDTO> getShipmentEstimationsDTO(@RequestBody ShipmentDTO shipmentDto) {
        ShipmentModel shipment = Mapper.toModel(shipmentDto);
        return new ResponseEntity<>(Mapper.toEstimationsDTO(this.shipmentService.getPriceEstimate(shipment)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShipmentModel> updateShipment(@PathVariable Long id, @RequestBody ShipmentDTO shipmentDto) {
        ShipmentModel shipment = Mapper.toModel(shipmentDto);
        return new ResponseEntity<>(this.shipmentService.updateShipment(id, shipment), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShipment(@PathVariable Long id) {
        this.shipmentService.deleteShipment(id);
        return ResponseEntity.noContent().build();
    }

}
