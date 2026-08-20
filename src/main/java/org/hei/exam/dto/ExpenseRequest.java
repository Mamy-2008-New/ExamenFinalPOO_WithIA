package org.hei.exam.dto;

import lombok.Getter;
import lombok.Setter;
import org.hei.exam.model.ExpenseFrequency;

import java.math.BigDecimal;

@Setter
@Getter
public class ExpenseRequest {

    private String userId;
    private BigDecimal amount;
    private String reason;
    private ExpenseFrequency frequency;

    public ExpenseRequest() {
    }

    public ExpenseRequest(String userId, BigDecimal amount, String reason, ExpenseFrequency frequency) {
        this.userId = userId;
        this.amount = amount;
        this.reason = reason;
        this.frequency = frequency;
    }

}
