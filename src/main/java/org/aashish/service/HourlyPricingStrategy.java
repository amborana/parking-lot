package org.aashish.service;

import org.aashish.domain.ticket.valueobject.PricingSnapshot;
import org.aashish.domain.ticket.aggregate.Ticket;
import org.aashish.domain.parking.valueobject.Vehicle;
import org.aashish.domain.parking.policy.PricingStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.Instant;

public class HourlyPricingStrategy implements PricingStrategy {

    private final BigDecimal hourlyRate;

    public HourlyPricingStrategy(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public PricingSnapshot snapshot(Vehicle vehicle) {
        // In the future, rate can depend on vehicle type
        return new PricingSnapshot(hourlyRate);
    }

    @Override
    public BigDecimal calculate(Ticket ticket) {

        Instant entryTime = ticket.getEntryTime();
        Instant exitTime = Instant.now();

        long minutes = Duration.between(entryTime, exitTime).toMinutes();

        long hours = (long) Math.ceil(minutes / 60.0);

        if (hours == 0) {
            hours = 1; // minimum charge = 1 hour
        }

        BigDecimal rate = ticket.getPricingSnapshot().hourlyRate();

        return rate
                .multiply(BigDecimal.valueOf(hours))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
