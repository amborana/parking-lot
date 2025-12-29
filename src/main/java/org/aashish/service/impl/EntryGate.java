package org.aashish.service.impl;

import org.aashish.dto.ParkingSpot;
import org.aashish.dto.Ticket;
import org.aashish.dto.Vehicle;
import org.aashish.factory.ParkingManagerFactory;

import java.util.Optional;

public class EntryGate {
    public Ticket book(Vehicle vehicle){
        Optional<ParkingSpot> parkingSpotOptional= ParkingManagerFactory.getParkingManager(vehicle.getType()).bookSpot(vehicle);
        if(parkingSpotOptional.isPresent()){
            return TicketManager.generateTicket(parkingSpotOptional.get());
        }
        else throw new RuntimeException("PARKING FULL");
    }

    public ParkingSpot findSpot(Vehicle vehicle){
        Optional<ParkingSpot> optionalParkingSpot=ParkingManagerFactory.getParkingManager(vehicle.getType()).findSpot();
        if(optionalParkingSpot.isPresent()) return optionalParkingSpot.get();
        else throw new RuntimeException("PARKING FULL");
    }
}
