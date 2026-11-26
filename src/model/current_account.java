package model;

import java.math.BigDecimal;

/**
 * Represents a current bank account.
 * Allows withdrawals within an authorized overdraft limit.
 */
public class CurrentAccount extends Account{

    private BigDecimal overdraftLimit;

    /**
     * Creates a current account with an overdraft limit.
     *
     * @param id the account identifier
     * @param accountNumber the account number
     * @param overdraftLimit the authorized overdraft limit
     * @throws IllegalArgumentException if the overdraft limit is null or negative
     */
    public CurrentAccount(int id, String accountNumber, BigDecimal overdraftLimit){
        super(id, accountNumber);
        if (overdraftLimit == null || overdraftLimit.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Le montant du découvert doit être positif.");
        }
        this.overdraftLimit = overdraftLimit;
    }

    /**
    * Returns the authorized overdraft limit.
    *
    * @return the overdraft limit
    */
    public BigDecimal getOverdraftLimit() {
        return overdraftLimit;
    }

    /**
    * Checks whether a withdrawal is allowed according to the overdraft limit.
    *
    * @param amount the amount to withdraw
    * @return true if the new balance remains within the authorized overdraft limit
    */
    @Override
    protected boolean canWithdraw(BigDecimal amount){

        BigDecimal newBalance = getBalance().subtract(amount);

        return newBalance.compareTo(overdraftLimit.negate()) >=0;

    }

}