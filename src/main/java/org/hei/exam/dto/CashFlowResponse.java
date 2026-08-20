package org.hei.exam.dto;

import lombok.Getter;
import lombok.Setter;
import org.hei.exam.model.ExpenseFrequency;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Représente un CashFlow "à plat" pour les réponses API : reprend les champs
 * communs (id, createdAt, amount) + les champs spécifiques à Donation OU à
 * Expense selon le type. Les champs non concernés restent à null.
 *
 * Les classes du modèle (CashFlow, Donation, Expense) ne sont pas modifiées :
 * ce DTO ne sert qu'à la couche API / persistance.
 */
@Setter
@Getter
public class CashFlowResponse {

    private String id;
    private Instant createdAt;
    private BigDecimal amount;
    private String type;      // "DONATION" ou "EXPENSE"
    private String userId;

    // Rempli uniquement si type = DONATION
    private String comment;

    // Remplis uniquement si type = EXPENSE
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
