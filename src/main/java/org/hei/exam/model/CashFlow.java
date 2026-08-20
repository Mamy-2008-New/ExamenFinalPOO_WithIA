package org.hei.exam.model;

import java.math.BigDecimal;
import java.time.Instant;

public class CashFlow {
    private String id;
    private Instant createdAt;
    private BigDecimal amount;

    public CashFlow(String id, Instant createdAt, BigDecimal amount) {
        this.id = id;
        this.createdAt = createdAt;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
