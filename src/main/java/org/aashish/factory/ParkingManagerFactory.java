package org.aashish.factory;

import org.aashish.dto.ParkingLot;
import org.aashish.dto.VehicleType;
import org.aashish.service.ParkingManager;
import org.aashish.service.impl.FourWheelerParkingManager;
import org.aashish.service.impl.TwoWheelerParkingManager;

public class ParkingManagerFactory {
    private static FourWheelerParkingManager fourWheelerParkingManager;
    private static TwoWheelerParkingManager twoWheelerParkingManager;

    public static ParkingManager getParkingManager(VehicleType type){
        switch (type) {
            case FOUR_WHEELER: {
                if (fourWheelerParkingManager == null) {
                    fourWheelerParkingManager = new FourWheelerParkingManager(ParkingLot.fourWheelerSpots);
                }
                return fourWheelerParkingManager;
            }
            case TWO_WHEELER: {
                if (twoWheelerParkingManager == null) {
                    twoWheelerParkingManager = new TwoWheelerParkingManager(ParkingLot.twoWheelerSpots);
                }
                return twoWheelerParkingManager;
            }
            default:
                throw new RuntimeException("PARKING NOT AVAILABLE");
        }
    }
}
