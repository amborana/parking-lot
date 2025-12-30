package org.aashish.dto;

import lombok.Getter;
import lombok.Setter;
import org.aashish.service.impl.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ParkingFloor {
    private List<ParkingSpot> parkingSpotList;

    public void setSpots(List<ParkingSpot> parkingSpotList){
        if(parkingSpotList.isEmpty()) {
            this.parkingSpotList=new ArrayList<>(parkingSpotList);
        }

    }
}
