package org.hei.exam.service;

import org.hei.exam.dto.BalanceResponse;
import org.hei.exam.dto.CashFlowResponse;
import org.hei.exam.dto.ExpenseRequest;
import org.hei.exam.model.CashFlow;
import org.hei.exam.model.Expense;
import org.hei.exam.model.User;
import org.hei.exam.repository.CashFlowRepository;
import org.hei.exam.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CashFlowService {

    private final CashFlowRepository cashFlowRepository;
    private final UserRepository userRepository;

    public CashFlowService(CashFlowRepository cashFlowRepository, UserRepository userRepository) {
        this.cashFlowRepository = cashFlowRepository;
        this.userRepository = userRepository;
    }

    public List<CashFlowResponse> getCashFlows(String type) {
        String normalized = normalizeType(type);
        return cashFlowRepository.findByType(normalized);
    }

    public List<CashFlowResponse> getCashFlowsForUser(String userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("Utilisateur introuvable : " + userId));
        return cashFlowRepository.findByUserId(userId);
    }

    public CashFlowResponse createExpense(ExpenseRequest request) {
        if (request.getUserId() == null || request.getUserId().isBlank()) {
            throw new IllegalArgumentException("userId est requis");
        }
        if (request.getAmount() == null || request.getAmount().signum() <= 0) {
            throw new IllegalArgumentException("amount doit être un nombre positif");
        }
        if (request.getFrequency() == null) {
            throw new IllegalArgumentException("frequency est requis");
        }

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new NoSuchElementException("Utilisateur introuvable : " + request.getUserId()));

        CashFlow cashFlow = new CashFlow(null, Instant.now(), request.getAmount());
        Expense expense = new Expense(request.getReason(), request.getFrequency());

        cashFlowRepository.saveExpense(user.getId(), cashFlow, expense);

        return cashFlowRepository.findById(cashFlow.getId())
                .orElseThrow(() -> new IllegalStateException("Erreur lors de la création de la dépense"));
    }

    public BalanceResponse getBalance() {
        BigDecimal totalDonations = cashFlowRepository.sumAmountByType("DONATION");
        BigDecimal totalExpenses = cashFlowRepository.sumAmountByType("EXPENSE");
        BigDecimal balance = totalDonations.subtract(totalExpenses);
        return new BalanceResponse(totalDonations, totalExpenses, balance);
    }

    private String normalizeType(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Le paramètre 'type' est requis (donation ou expense)");
        }
        String normalized = type.trim().toUpperCase();
        if (!normalized.equals("DONATION") && !normalized.equals("EXPENSE")) {
            throw new IllegalArgumentException("Le paramètre 'type' doit valoir 'donation' ou 'expense'");
        }
        return normalized;
    }
}