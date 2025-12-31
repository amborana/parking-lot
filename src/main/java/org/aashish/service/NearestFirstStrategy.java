package org.aashish.service;

import org.aashish.domain.parking.entity.ParkingFloor;
import org.aashish.domain.parking.valueobject.Vehicle;
import org.aashish.domain.parking.entity.ParkingSpot;
import org.aashish.domain.parking.policy.SpotAllocationStrategy;

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
