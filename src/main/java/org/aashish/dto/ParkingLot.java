package org.aashish.dto;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class ParkingLot {
    public static final List<ParkingSpot> twoWheelerSpots=new CopyOnWriteArrayList<>();
    public static final List<ParkingSpot> fourWheelerSpots=new CopyOnWriteArrayList<>();

    private static void setTwoWheelerSpots(List<ParkingSpot> twoWheelerSpots){
        if(twoWheelerSpots.isEmpty()){
            ParkingLot.twoWheelerSpots.addAll(twoWheelerSpots);
        }
    }
    private static void setFourWheelerSpots(List<ParkingSpot> fourWheelerSpots){
        if(fourWheelerSpots.isEmpty()){
            ParkingLot.fourWheelerSpots.addAll(fourWheelerSpots);
        }
    }
}
