import com.joaopedromattos.shipment_company.shipment.shipmentMethods.VehicleType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShipmentDTO {

    private double distance;
    private double weight;
    private VehicleType vehicleType;

}
