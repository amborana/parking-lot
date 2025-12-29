package org.aashish.service.impl;

import org.aashish.dto.ParkingSpot;
import org.aashish.dto.Ticket;

import java.sql.Timestamp;

public class TicketManager {

    public static Ticket generateTicket(ParkingSpot spot){
        Ticket tic=new Ticket();
        tic.setSpot(spot);
        tic.setEntryTime(new Timestamp(System.currentTimeMillis()));
        tic.setStaff(spot.getVehicle().isExempted());
        return tic;
    }
}
