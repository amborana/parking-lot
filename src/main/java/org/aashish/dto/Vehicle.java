package org.aashish.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehicle {
    private String vehicleNumber;
    private VehicleType type;
    private boolean exempted;
}
