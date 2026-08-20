package org.hei.exam.repository;

import org.hei.exam.dto.CashFlowResponse;
import org.hei.exam.model.CashFlow;
import org.hei.exam.model.Donation;
import org.hei.exam.model.Expense;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CashFlowRepository {

    List<CashFlowResponse> findByType(String type);

    List<CashFlowResponse> findByUserId(String userId);

    Optional<CashFlowResponse> findById(String id);

    void saveDonation(String userId, CashFlow cashFlow, Donation donation);

    void saveExpense(String userId, CashFlow cashFlow, Expense expense);

    BigDecimal sumAmountByType(String type);
}
