package com.ironhack.ironbank.Account;

import java.math.BigDecimal;

public class CreditAccount extends CheckingAccount{
    private BigDecimal creditLimit;
    private double interestRate;

    private static final BigDecimal DEFAULT_CREDIT_LIMIT = BigDecimal.valueOf(100);
    private static final BigDecimal MAXIMUM_CREDIT_LIMIT = BigDecimal.valueOf(100000);
    private static final double DEFAULT_INTEREST_RATE = 0.2;
    private static final double MINIMUM_INTEREST_RATE = 0.1;
}
