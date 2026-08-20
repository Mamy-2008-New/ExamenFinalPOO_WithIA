package org.hei.exam.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Réponse pour GET /balance : solde = total des dons - total des dépenses.
 */
@Setter
@Getter
public class BalanceResponse {

    private BigDecimal totalDonations;
    private BigDecimal totalExpenses;
    private BigDecimal balance;

    public BalanceResponse() {
    }

    public BalanceResponse(BigDecimal totalDonations, BigDecimal totalExpenses, BigDecimal balance) {
        this.totalDonations = totalDonations;
        this.totalExpenses = totalExpenses;
        this.balance = balance;
    }

}
