package org.aashish.service;

import org.aashish.dto.ParkingFloor;
import org.aashish.dto.Vehicle;
import org.aashish.service.impl.ParkingSpot;

import java.util.List;
import java.util.Optional;

public interface SpotAllocationStrategy {
    Optional<ParkingSpot> allocate(List<ParkingFloor> floors, Vehicle vehicle);
}
