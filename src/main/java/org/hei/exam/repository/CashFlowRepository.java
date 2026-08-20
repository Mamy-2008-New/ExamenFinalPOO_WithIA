package org.hei.exam.repository;

import org.hei.exam.dto.CashFlowResponse;
import org.hei.exam.model.CashFlow;
import org.hei.exam.model.Donation;
import org.hei.exam.model.Expense;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CashFlowRepository {

    /** GET /cash-flows?type=donation|expense */
    List<CashFlowResponse> findByType(String type);

    /** GET /users/{id}/cash-flows */
    List<CashFlowResponse> findByUserId(String userId);

    Optional<CashFlowResponse> findById(String id);

    /** Persiste un CashFlow + sa Donation associée (2 tables). */
    void saveDonation(String userId, CashFlow cashFlow, Donation donation);

    /** Persiste un CashFlow + son Expense associée (2 tables). */
    void saveExpense(String userId, CashFlow cashFlow, Expense expense);

    /** Somme des montants pour un type donné ("DONATION" ou "EXPENSE"), utilisé par GET /balance. */
    BigDecimal sumAmountByType(String type);
}
