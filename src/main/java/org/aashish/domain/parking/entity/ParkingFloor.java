package org.aashish.domain.parking.entity;

import lombok.Getter;

import java.util.List;


@Getter
public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSpot> spots;

    public ParkingFloor(int floorNumber, List<ParkingSpot> spots) {
        this.floorNumber = floorNumber;
        this.spots = spots;
    }

}


