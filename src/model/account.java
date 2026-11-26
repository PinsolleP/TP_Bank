package model;

import java.math.BigDecimal;
import java.time.LocalDate;
/**
 * Represents an abstract bank account.
 * Provides common attributes and methods for all account types.
 */
public abstract  class Account{

    private int id;
    private String accountNumber;
    private BigDecimal balance;
    private LocalDate creationDate;

    /**
     * Creates a bank account with an initial balance of zero.
     *
     * @param id the account identifier
     * @param accountNumber the account number
     */
    public Account(int id, String accountNumber) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = BigDecimal.ZERO;
        this.creationDate = LocalDate.now();
    }

    /**
     * Returns the account identifier.
     *
     * @return the account ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the account number.
     *
     * @return the account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Returns the account creation date.
     *
     * @return the creation date
     */
    public LocalDate getCreationDate() {
        return creationDate;
    }

    /**
     * Checks whether a withdrawal is allowed.
     *
     * @param amount the amount to withdraw
     * @return true if the withdrawal is allowed, otherwise false
     */
    protected abstract boolean canWithdraw(BigDecimal amount);

    /**
     * Adds an amount to the account balance.
     *
     * @param amount the amount to deposit
     * @throws IllegalArgumentException if the amount is not positive
     */
    public void deposit(BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO)<=0){
            throw new IllegalArgumentException("Le montant doit être strictement positif.");
        }
        balance = balance.add(amount);
    }

    /**
     * Removes an amount from the account balance.
     *
     * @param amount the amount to withdraw
     * @throws IllegalArgumentException if the amount is not positive or the balance is insufficient
     */
    public void withdraw(BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO)<=0){
            throw new IllegalArgumentException("Le montant doit être strictement positif.");
        } else if (!canWithdraw(amount)) {
            throw new IllegalArgumentException("Votre solde est insuffisant.");
        }
        balance = balance.subtract(amount);
    }

    /**
     * Returns the current account balance.
     *
     * @return the current balance
     */
    public BigDecimal getBalance(){
        return balance;
    }
}