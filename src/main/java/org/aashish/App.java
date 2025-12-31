package org.aashish;


import org.aashish.domain.parking.entity.ParkingFloor;
import org.aashish.domain.parking.valueobject.VehicleType;
import org.aashish.domain.parking.aggregate.ParkingLot;
import org.aashish.domain.parking.entity.ParkingSpot;
import org.aashish.domain.payment.aggregate.Payment;
import org.aashish.domain.ticket.aggregate.Ticket;
import org.aashish.domain.parking.valueobject.Vehicle;
import org.aashish.domain.payment.policy.PaymentMethod;
import org.aashish.domain.parking.policy.PricingStrategy;
import org.aashish.domain.parking.policy.SpotAllocationStrategy;
import org.aashish.service.*;

import java.math.BigDecimal;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Vehicle car1 = new Vehicle("KA01AB1234", VehicleType.CAR, false);
        Vehicle car2 = new Vehicle("KA01AB5678", VehicleType.CAR, false);

        ParkingSpot s1 = new CompactSpot();
        ParkingSpot s2 = new CompactSpot();

        ParkingFloor floor1 = new ParkingFloor(1, List.of(s1, s2));
        SpotAllocationStrategy allocationStrategy = new NearestFirstStrategy();
        PricingStrategy pricingStrategy = new HourlyPricingStrategy(BigDecimal.valueOf(50));
        ParkingLot parkingLot = new ParkingLot(List.of(floor1), allocationStrategy, pricingStrategy);

        EntryGate entryGate = new EntryGate(parkingLot);
        ExitGate exitGate = new ExitGate(parkingLot);
        Ticket t1 = entryGate.enter(car1);
        System.out.println("Car1 parked at " + t1.getEntryTime());

        // --- Test 2: Park second car ---
        Ticket t2 = entryGate.enter(car2);
        System.out.println("Car2 parked at " + t2.getEntryTime());

        // --- Test 3: Parking full ---
        try {
            entryGate.enter(new Vehicle("KA01AB9999", VehicleType.CAR, false));
        } catch (Exception e) {
            System.out.println("Parking full as expected");
        }


        // --- Simulate time spent ---
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // --- Test 4: Exit first car ---
        PaymentMethod cash = new CashPayment();
        Payment payment1 = exitGate.exit(t1, cash);

        System.out.println("Car1 payment: " + payment1.getAmount());
        System.out.println("Payment status: " + payment1.getStatus());
    }
}
