package org.aashish.service.impl;

import org.aashish.dto.Ticket;
import org.aashish.dto.VehicleType;

import java.sql.Timestamp;

public class BillGenerator {

    public static Ticket generateBill(Ticket ticket){
        ticket.setExitTime(new Timestamp(System.currentTimeMillis()));
        if(ticket.getSpot().getVehicleType().equals(VehicleType.FOUR_WHEELER))
            return calculateTwoWheelerParkingCost(ticket);
        else{
            return calculateFourWheelerParkingCost(ticket);
        }
    }
    private static Ticket calculateTwoWheelerParkingCost(Ticket ticket){
       int cost= (int) Math.ceil((double) (ticket.getEntryTime().getTime() - ticket.getExitTime().getTime()) /1000*60*60)*20;
       ticket.setCost(cost);
       return ticket;
    }
    private static Ticket calculateFourWheelerParkingCost(Ticket ticket){
        int cost= (int) Math.ceil((double) (ticket.getEntryTime().getTime() - ticket.getExitTime().getTime()) /1000*60*60)*80;
        ticket.setCost(cost);
        return ticket;
    }
}
