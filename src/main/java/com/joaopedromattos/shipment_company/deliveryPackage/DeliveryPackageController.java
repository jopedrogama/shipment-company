package com.joaopedromattos.shipment_company.deliveryPackage;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/package")
public class DeliveryPackageController {
    
    @GetMapping()
    public String getPackages(){
        return "";
    }

    @GetMapping("/id")
    public String getPackageById(@PathVariable int id){
        return "";
    }

    @PostMapping
    public String createPackage(@RequestBody String str){
        return "";
    }

    @PutMapping("/{id}")
    public String updatePackage(@PathVariable String id, @RequestBody String entity) {
        //TODO: process PUT request
        
        return "";
    }
}
