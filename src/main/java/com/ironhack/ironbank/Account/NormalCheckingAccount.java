package com.ironhack.ironbank.Account;

import com.ironhack.ironbank.User.User;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class NormalCheckingAccount extends CheckingAccount{
    private static final BigDecimal minimumBalance = BigDecimal.valueOf(250);
    private static final BigDecimal monthlyMaintenanceFee = BigDecimal.valueOf(12);

    public NormalCheckingAccount(User primaryOwner, String name, String secretKey, User secondaryOwner) {
        super(primaryOwner, name, secretKey, secondaryOwner);
    }

    public NormalCheckingAccount(User primaryOwner, String name, String secretKey) {
        super(primaryOwner, name, secretKey);
    }
}
