package model;

import java.math.BigDecimal;

public class SavingsAccount extends Account{

    private BigDecimal interestRate;

    public SavingsAccount(int id, String accountNumber, BigDecimal interestRate){
        super(id, accountNumber);
        if (interestRate == null || interestRate.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Le taux d'intéret doit être positif.");
    }
        this.interestRate = interestRate;
}

public BigDecimal getInterestRate() {
    return interestRate;
}

@Override
protected boolean canWithdraw(BigDecimal amount){
    BigDecimal newBalance = getBalance().subtract(amount);
    return newBalance.compareTo(BigDecimal.ZERO) >= 0;
}

public BigDecimal calculateInterest(){
    BigDecimal newBalance = getBalance().multiply(interestRate);
    return newBalance;
}