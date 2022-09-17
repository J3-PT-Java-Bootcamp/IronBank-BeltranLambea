package com.ironhack.ironbank.Account;

import java.math.BigDecimal;

public class SavingsAccount extends CheckingAccount{
    private double interestRate;
    private BigDecimal minimumBalance;
    private static final double DEFAULT_INTEREST_RATE = 0.0025;
    private static final double MAXIMUM_INTEREST_RATE = 0.5;
    private static final BigDecimal DEFAULT_MINIMUM_BALANCE = BigDecimal.valueOf(1000);
    private static final BigDecimal MINIMUM_MINIMUM_BALANCE = BigDecimal.valueOf(100);
}
