package com.ironhack.ironbank.Account;

import java.math.BigDecimal;

public class NormalCheckingAccount extends CheckingAccount{
    private static final BigDecimal minimumBalance = BigDecimal.valueOf(0.0);
    private static final BigDecimal monthlyMaintenanceFee = BigDecimal.valueOf(0.0);
}
