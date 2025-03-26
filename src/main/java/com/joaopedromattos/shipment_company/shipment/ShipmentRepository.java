package com.joaopedromattos.shipment_company.shipment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<ShipmentModel, Long> {

    List<ShipmentModel> findByCustomerId(Long id);

}
