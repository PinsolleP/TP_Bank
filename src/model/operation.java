package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Operation {

    private int id;
    private OperationType operationType;
    private BigDecimal amount;
    private LocalDate operationDate;
    private Account account;

    public Operation(int id, OperationType operationType, BigDecimal amount, LocalDate operationDate, Account account) {
        this.id = id;
        this.operationType = operationType;
        this.amount = amount;
        this.operationDate = operationDate;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getOperationDate() {
        return operationDate;
    }

    public Account getAccount() {
        return account;
    }
}
