package org.aashish.dto;

import lombok.Data;

@Data
public class ParkingSpot {
    private int id;
    private Vehicle vehicle;
    private boolean available=true;
    private VehicleType vehicleType;
    private boolean premium=false;
}
