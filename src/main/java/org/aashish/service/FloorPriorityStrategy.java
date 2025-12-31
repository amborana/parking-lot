package org.aashish.service;

import org.aashish.domain.parking.entity.ParkingFloor;
import org.aashish.domain.parking.valueobject.Vehicle;
import org.aashish.domain.parking.entity.ParkingSpot;
import org.aashish.domain.parking.policy.SpotAllocationStrategy;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FloorPriorityStrategy implements SpotAllocationStrategy {
    @Override
    public Optional<ParkingSpot> allocate(List<ParkingFloor> floors, Vehicle vehicle) {
        return floors.stream()
                .sorted(Comparator.comparingInt(ParkingFloor::getFloorNumber))
                .flatMap(floor->floor.getSpots().stream())
                .filter(parkingSpot -> parkingSpot.tryOccupy(vehicle)).findFirst();
    }
}
