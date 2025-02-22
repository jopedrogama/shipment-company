package com.joaopedromattos.shipment_company.shipment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    @GetMapping("/{id}")
    public String getShipmentByCustomerId(@PathVariable int id) {
        return Integer.toString(id);
    }
    
    @PostMapping
    public String postMethodName(@RequestBody String str) {
        return str;
    }
    
}
