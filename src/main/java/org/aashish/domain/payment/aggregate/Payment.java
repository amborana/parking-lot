package org.aashish.domain.payment.aggregate;

import lombok.Getter;
import org.aashish.domain.payment.valueobject.PaymentStatus;

import java.math.BigDecimal;
import java.util.UUID;


public class Payment {
    private final UUID uuid;
    @Getter
    private PaymentStatus status;
    @Getter
    private final BigDecimal amount;

    public Payment(BigDecimal amount) {
        this.uuid = UUID.randomUUID();;
        this.amount = amount;
        this.status = PaymentStatus.INITIATED;
    }

    public void markSuccess() {
        this.status = PaymentStatus.SUCCESS;
    }

    public void markFailed() {
        this.status = PaymentStatus.FAILED;
    }
}
