package org.aashish.dto;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ParkingLot {
    @Getter
    private static final List<ParkingSpot> twoWheelerSpots=new CopyOnWriteArrayList<>();
    @Getter
    private static final List<ParkingSpot> fourWheelerSpots=new CopyOnWriteArrayList<>();

    public static void setTwoWheelerSpots(List<ParkingSpot> twoWheelerSpots){
        if(twoWheelerSpots.isEmpty()){
            ParkingLot.twoWheelerSpots.addAll(twoWheelerSpots);
        }
    }
    public static void setFourWheelerSpots(List<ParkingSpot> fourWheelerSpots){
        if(fourWheelerSpots.isEmpty()){
            ParkingLot.fourWheelerSpots.addAll(fourWheelerSpots);
        }
    }

}
