package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract  class Account{

    private int id;
    private String accountNumber;
    private BigDecimal balance;
    private LocalDate creationDate;

    public Account(int id, String accountNumber) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = BigDecimal.ZERO;
        this.creationDate = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    protected abstract boolean canWithdraw(BigDecimal amount);

    public void deposit(BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO)<=0){
            throw new IllegalArgumentException("Le montant doit être strictement positif.");
        }
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO)<=0){
            throw new IllegalArgumentException("Le montant doit être strictement positif.");
        } else if (!canWithdraw(amount)) {
            throw new IllegalArgumentException("Votre solde est insuffisant.");
        }
        balance = balance.subtract(amount);
    }

    public BigDecimal getBalance(){
        return balance;
    }
}