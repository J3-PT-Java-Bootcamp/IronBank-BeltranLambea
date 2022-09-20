package com.ironhack.ironbank.Account;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class NormalCheckingAccount extends CheckingAccount{
    private static final BigDecimal minimumBalance = BigDecimal.valueOf(250);
    private static final BigDecimal monthlyMaintenanceFee = BigDecimal.valueOf(12);
}
