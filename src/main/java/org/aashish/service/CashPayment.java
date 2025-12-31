package org.aashish.service;

import org.aashish.domain.payment.aggregate.Payment;
import org.aashish.domain.payment.policy.PaymentMethod;

public class CashPayment implements PaymentMethod {
    @Override
    public void pay(Payment payment) {
        payment.markSuccess();
    }
}
