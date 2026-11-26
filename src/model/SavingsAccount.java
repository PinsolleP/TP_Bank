package model;

import java.math.BigDecimal;

/**
 * Represents a savings bank account.
 * Allows withdrawals only within the available balance.
 */
public class SavingsAccount extends Account{

    private BigDecimal interestRate;

    /**
     * Creates a savings account with an interest rate.
     *
     * @param id the account identifier
     * @param accountNumber the account number
     * @param interestRate the interest rate applied to the account
     * @throws IllegalArgumentException if the interest rate is null or negative
     */
    public SavingsAccount(int id, String accountNumber, BigDecimal interestRate){
        super(id, accountNumber);
        if (interestRate == null || interestRate.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Le taux d'intéret doit être positif.");
    }
        this.interestRate = interestRate;
}

    /**
     * Returns the account interest rate.
     *
     * @return the interest rate
     */
public BigDecimal getInterestRate() {
    return interestRate;
}

    /**
     * Checks whether a withdrawal is allowed without creating a negative balance.
     *
     * @param amount the amount to withdraw
     * @return true if the balance is sufficient, otherwise false
     */
@Override
protected boolean canWithdraw(BigDecimal amount){
    BigDecimal newBalance = getBalance().subtract(amount);
    return newBalance.compareTo(BigDecimal.ZERO) >= 0;
}

    /**
     * Calculates the interest earned based on the current balance.
     *
     * @return the calculated interest amount
     */
public BigDecimal calculateInterest(){
    BigDecimal newBalance = getBalance().multiply(interestRate);
    return newBalance;
}