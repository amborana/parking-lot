package org.aashish.service.impl;

import org.aashish.dto.*;
import org.aashish.service.ParkingManager;

import java.util.List;
import java.util.Optional;

public class TwoWheelerParkingManager implements ParkingManager {
    private final List<ParkingSpot> parkingSpotList;

    public TwoWheelerParkingManager(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    @Override
    public Optional<ParkingSpot> bookSpot(Vehicle vehicle) {
        Optional<ParkingSpot> parkingSpot = findSpot();

        if (parkingSpot.isPresent()) {
            ParkingSpot spot = parkingSpot.get();
            assignSpot(spot, vehicle);
            return Optional.of(spot);
        }
        return Optional.empty();
    }

    @Override
    public Optional<ParkingSpot> findSpot() {
        return parkingSpotList.stream().filter(ParkingSpot::isAvailable).findFirst();
    }

}
