package org.aashish.service;

import org.aashish.domain.parking.aggregate.ParkingLot;
import org.aashish.domain.payment.aggregate.Payment;
import org.aashish.domain.payment.valueobject.PaymentStatus;
import org.aashish.domain.ticket.aggregate.Ticket;
import org.aashish.domain.parking.policy.Gate;
import org.aashish.domain.payment.policy.PaymentMethod;

import java.math.BigDecimal;

public class ExitGate extends Gate {

    public ExitGate(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public Payment exit(Ticket ticket, PaymentMethod paymentMethod) {

        BigDecimal amount = parkingLot.calculateCharge(ticket);
        Payment payment = new Payment(amount);

        paymentMethod.pay(payment);

        if (payment.getStatus() == PaymentStatus.SUCCESS) {
            parkingLot.releaseSpot(ticket);
        } else {
            throw new RuntimeException("PAYMENT FAILED");
        }
        ticket.close();
        parkingLot.releaseSpot(ticket);
        return payment;
    }
}