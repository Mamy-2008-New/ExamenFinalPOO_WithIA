package org.hei.exam.controller;

import org.hei.exam.dto.BalanceResponse;
import org.hei.exam.dto.CashFlowResponse;
import org.hei.exam.dto.ExpenseRequest;
import org.hei.exam.service.CashFlowService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class CashFlowController {

    private final CashFlowService cashFlowService;

    public CashFlowController(CashFlowService cashFlowService) {
        this.cashFlowService = cashFlowService;
    }

    // GET /cash-flows?type=donation|expense
    @GetMapping("/cash-flows")
    public List<CashFlowResponse> getCashFlows(@RequestParam String type) {
        return cashFlowService.getCashFlows(type);
    }

    // GET /users/{id}/cash-flows
    @GetMapping("/users/{id}/cash-flows")
    public List<CashFlowResponse> getUserCashFlows(@PathVariable("id") String userId) {
        return cashFlowService.getCashFlowsForUser(userId);
    }

    // POST /expenses
    @PostMapping("/expenses")
    @ResponseStatus(HttpStatus.CREATED)
    public CashFlowResponse createExpense(@RequestBody ExpenseRequest request) {
        return cashFlowService.createExpense(request);
    }

    // GET /balance
    @GetMapping("/balance")
    public BalanceResponse getBalance() {
        return cashFlowService.getBalance();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBadRequest(IllegalArgumentException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(NoSuchElementException ex) {
        return ex.getMessage();
    }
}