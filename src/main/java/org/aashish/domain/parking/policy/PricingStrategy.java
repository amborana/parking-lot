package org.aashish.domain.parking.policy;

import org.aashish.domain.ticket.valueobject.PricingSnapshot;
import org.aashish.domain.ticket.aggregate.Ticket;
import org.aashish.domain.parking.valueobject.Vehicle;

import java.math.BigDecimal;

public interface PricingStrategy {
    PricingSnapshot snapshot(Vehicle vehicle);
    BigDecimal calculate(Ticket ticket);
}
