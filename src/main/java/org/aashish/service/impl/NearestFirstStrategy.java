package org.aashish.service.impl;

import org.aashish.dto.ParkingFloor;
import org.aashish.dto.Vehicle;
import org.aashish.service.SpotAllocationStrategy;

import java.util.List;
import java.util.Optional;

public class NearestFirstStrategy implements SpotAllocationStrategy {
    @Override
    public Optional<ParkingSpot> allocate(List<ParkingFloor> floors, Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            for (ParkingSpot spot : floor.getSpots()) {
                if (spot.tryOccupy(vehicle)) {
                    return Optional.of(spot);
                }
            }
        }
        return Optional.empty();
    }

}
