package org.aashish.dto;

import org.aashish.service.PricingStrategy;
import org.aashish.service.SpotAllocationStrategy;

import java.util.List;

public class ParkingLot {
    private final List<ParkingFloor> floors;
    private final SpotAllocationStrategy allocationStrategy;
    private final PricingStrategy pricingStrategy;

    public ParkingLot(
            List<ParkingFloor> floors,
            SpotAllocationStrategy allocationStrategy,
            PricingStrategy pricingStrategy
    ) {
        this.floors = floors;
        this.allocationStrategy = allocationStrategy;
        this.pricingStrategy = pricingStrategy;
    }

}
