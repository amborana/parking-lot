package org.aashish.service.impl;

import org.aashish.dto.Vehicle;
import org.aashish.dto.VehicleType;

public class CompactSpot extends ParkingSpot{
    @Override
    protected boolean canFit(Vehicle vehicle) {
        return vehicle.getType() == VehicleType.CAR;
    }
}
