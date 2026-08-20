package org.hei.exam.model;

public class Expense {
    private String reason;
    private ExpenseFrequency frequency;

    public Expense(String reason, ExpenseFrequency frequency) {
        this.reason = reason;
        this.frequency = frequency;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ExpenseFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(ExpenseFrequency frequency) {
        this.frequency = frequency;
    }
}
