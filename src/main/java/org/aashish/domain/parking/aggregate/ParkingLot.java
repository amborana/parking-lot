package org.aashish.domain.parking.aggregate;

import org.aashish.domain.parking.entity.ParkingFloor;
import org.aashish.domain.parking.valueobject.Vehicle;
import org.aashish.domain.ticket.aggregate.Ticket;
import org.aashish.domain.parking.policy.PricingStrategy;
import org.aashish.domain.parking.policy.SpotAllocationStrategy;
import org.aashish.domain.parking.entity.ParkingSpot;

import java.math.BigDecimal;
import java.time.Instant;
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

    public Ticket park(Vehicle vehicle) {
        ParkingSpot spot = allocationStrategy
                .allocate(floors, vehicle)
                .orElseThrow(() -> new RuntimeException("PARKING FULL"));

        return new Ticket(
                Instant.now(),
                pricingStrategy.snapshot(vehicle),
                spot
        );
    }

    public BigDecimal calculateCharge(Ticket ticket) {
        return pricingStrategy.calculate(ticket);
    }

    public void releaseSpot(Ticket ticket) {
        ticket.getSpot().vacate();
    }
}
