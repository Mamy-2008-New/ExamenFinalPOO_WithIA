package org.hei.exam.dto;

import lombok.Getter;
import lombok.Setter;
import org.hei.exam.model.ExpenseFrequency;

import java.math.BigDecimal;
import java.time.Instant;

@Setter
@Getter
public class CashFlowResponse {

    private String id;
    private Instant createdAt;
    private BigDecimal amount;
    private String type;
    private String userId;

    private String comment;

    private String reason;
    private ExpenseFrequency frequency;

    public CashFlowResponse() {
    }

    public CashFlowResponse(String id, Instant createdAt, BigDecimal amount, String type, String userId,
                             String comment, String reason, ExpenseFrequency frequency) {
        this.id = id;
        this.createdAt = createdAt;
        this.amount = amount;
        this.type = type;
        this.userId = userId;
        this.comment = comment;
        this.reason = reason;
        this.frequency = frequency;
    }

}
