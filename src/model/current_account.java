package model;

import java.math.BigDecimal;

public class CurrentAccount extends Account{

    private BigDecimal overdraftLimit;

    public CurrentAccount(int id, String accountNumber, BigDecimal overdraftLimit){
        super(id, accountNumber);
        if (overdraftLimit == null || overdraftLimit.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Le montant du découvert doit être positif.");
        }
        this.overdraftLimit = overdraftLimit;
    }

    public BigDecimal getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    protected boolean canWithdraw(BigDecimal amount){

        BigDecimal newBalance = getBalance().subtract(amount);

        return newBalance.compareTo(overdraftLimit.negate()) >=0;

    }

}