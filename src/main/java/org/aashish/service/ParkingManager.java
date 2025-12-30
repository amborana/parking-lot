package org.aashish.service;

import org.aashish.service.impl.ParkingSpot;
import org.aashish.dto.Vehicle;

import java.util.Optional;

public interface ParkingManager {
    Optional<ParkingSpot> bookSpot(Vehicle vehicle);

    Optional<ParkingSpot> findSpot();


    default void assignSpot(ParkingSpot parkingSpot, Vehicle vehicle) {
        parkingSpot.setAvailable(false);
        parkingSpot.setVehicle(vehicle);
    }

    default void freeUpSpot(ParkingSpot parkingSpot) {
        parkingSpot.setVehicle(null);
        parkingSpot.setAvailable(true);
    }
}
