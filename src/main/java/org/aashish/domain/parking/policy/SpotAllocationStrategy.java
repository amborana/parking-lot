package org.aashish.domain.parking.policy;

import org.aashish.domain.parking.entity.ParkingFloor;
import org.aashish.domain.parking.valueobject.Vehicle;
import org.aashish.domain.parking.entity.ParkingSpot;

import java.util.List;
import java.util.Optional;

public interface SpotAllocationStrategy {
    Optional<ParkingSpot> allocate(List<ParkingFloor> floors, Vehicle vehicle);
}
