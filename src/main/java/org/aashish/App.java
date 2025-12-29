package org.aashish;


import org.aashish.dto.*;
import org.aashish.service.impl.EntryGate;
import org.aashish.service.impl.ExitGate;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class App
{
    public static void main( String[] args )
    {
        List<ParkingSpot> two=new CopyOnWriteArrayList<>();
        List<ParkingSpot> four=new CopyOnWriteArrayList<>();

        ParkingSpot ps1=new ParkingSpot();
        ps1.setId(1);
        ps1.setVehicleType(VehicleType.TWO_WHEELER);

        ParkingSpot ps2=new ParkingSpot();
        ps2.setId(2);
        ps2.setVehicleType(VehicleType.TWO_WHEELER);

        two.add(ps1);
        two.add(ps2);

        ParkingSpot ps41=new ParkingSpot();
        ps41.setId(41);
        ps41.setVehicleType(VehicleType.FOUR_WHEELER);

        ParkingSpot ps42=new ParkingSpot();
        ps42.setVehicleType(VehicleType.FOUR_WHEELER);

        four.add(ps41);
        four.add(ps42);

        ParkingLot.setTwoWheelerSpots(two);
        ParkingLot.setFourWheelerSpots(four);

        Vehicle shine=new Vehicle("1234",VehicleType.TWO_WHEELER,false);

        EntryGate entryGate=new EntryGate();
        Ticket tic=entryGate.book(shine);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ExitGate exitGate=new ExitGate();
        exitGate.generateBill(tic);

        System.out.println(tic);

    }
}
