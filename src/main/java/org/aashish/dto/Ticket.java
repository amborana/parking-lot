package org.aashish.dto;

import org.aashish.service.impl.ParkingSpot;

import java.time.Instant;

public class Ticket {

    private final Instant entryTime;
    private final PricingSnapshot pricingSnapshot;
    private final ParkingSpot spot;

    public Ticket(Instant entryTime,
                  PricingSnapshot pricingSnapshot,
                  ParkingSpot spot) {
        this.entryTime = entryTime;
        this.pricingSnapshot = pricingSnapshot;
        this.spot = spot;
    }
}
