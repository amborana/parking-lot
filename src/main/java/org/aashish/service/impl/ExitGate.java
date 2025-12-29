package org.aashish.service.impl;

import org.aashish.dto.Ticket;
import org.aashish.factory.ParkingManagerFactory;

public class ExitGate {
    public Ticket generateBill(Ticket ticket){
        ParkingManagerFactory.getParkingManager(ticket.getSpot().getVehicleType()).freeUpSpot(ticket.getSpot());
        return BillGenerator.generateBill(ticket);
    }
}
