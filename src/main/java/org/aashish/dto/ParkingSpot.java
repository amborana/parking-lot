package org.aashish.dto;

import lombok.Data;

@Data
public class ParkingSpot {
    private Vehicle vehicle;
    private boolean available;
    private VehicleType vehicleType;
    private boolean premium;
}
