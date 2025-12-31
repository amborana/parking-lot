package org.aashish.service;

import org.aashish.domain.parking.aggregate.ParkingLot;
import org.aashish.domain.ticket.aggregate.Ticket;
import org.aashish.domain.parking.valueobject.Vehicle;
import org.aashish.domain.parking.policy.Gate;

public class EntryGate extends Gate {
    public EntryGate(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public Ticket enter(Vehicle vehicle) {
        return parkingLot.park(vehicle);
    }
}
