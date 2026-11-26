package model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Represents a banking operation associated with an account.
 * Stores the operation type, amount and date.
 */
public class Operation {

    private int id;
    private OperationType operationType;
    private BigDecimal amount;
    private LocalDate operationDate;
    private Account account;

    /**
     * Creates a banking operation.
     *
     * @param id the operation identifier
     * @param operationType the type of operation
     * @param amount the operation amount
     * @param operationDate the date of the operation
     * @param account the account associated with the operation
     */
    public Operation(int id, OperationType operationType, BigDecimal amount, LocalDate operationDate, Account account) {
        this.id = id;
        this.operationType = operationType;
        this.amount = amount;
        this.operationDate = operationDate;
        this.account = account;
    }

    /**
     * Returns the operation identifier.
     *
     * @return the operation ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the operation type.
     *
     * @return the operation type
     */
    public OperationType getOperationType() {
        return operationType;
    }

    /**
     * Returns the operation amount.
     *
     * @return the operation amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Returns the operation date.
     *
     * @return the operation date
     */
    public LocalDate getOperationDate() {
        return operationDate;
    }

    /**
     * Returns the account associated with the operation.
     *
     * @return the associated account
     */
    public Account getAccount() {
        return account;
    }
}
