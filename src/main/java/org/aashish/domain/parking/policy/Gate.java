package org.aashish.domain.parking.policy;

import org.aashish.domain.parking.aggregate.ParkingLot;

public abstract class Gate {

    protected final ParkingLot parkingLot;

    protected Gate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}