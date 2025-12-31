package org.aashish.service;

import org.aashish.domain.parking.valueobject.Vehicle;
import org.aashish.domain.parking.valueobject.VehicleType;
import org.aashish.domain.parking.entity.ParkingSpot;

public class CompactSpot extends ParkingSpot {
    @Override
    protected boolean canFit(Vehicle vehicle) {
        return vehicle.getType() == VehicleType.CAR;
    }
}
