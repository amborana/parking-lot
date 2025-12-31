package org.aashish.domain.payment.policy;

import org.aashish.domain.payment.aggregate.Payment;

public interface PaymentMethod {
    void pay(Payment payment);
}
