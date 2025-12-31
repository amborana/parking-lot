package org.aashish.domain.ticket.aggregate;

import lombok.Data;
import org.aashish.domain.ticket.valueobject.PricingSnapshot;
import org.aashish.domain.parking.entity.ParkingSpot;

import java.time.Instant;

@Data
public class Ticket {

    private final Instant entryTime;
    private final PricingSnapshot pricingSnapshot;
    private final ParkingSpot spot;
    private boolean closed = false;
    public Ticket(Instant entryTime,
                  PricingSnapshot pricingSnapshot,
                  ParkingSpot spot) {
        this.entryTime = entryTime;
        this.pricingSnapshot = pricingSnapshot;
        this.spot = spot;
    }


    public void close() {
        if (closed) throw new IllegalStateException("Ticket already closed");
        closed = true;
    }
}
