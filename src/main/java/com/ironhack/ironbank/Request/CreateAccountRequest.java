package com.ironhack.ironbank.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Setter
@Component
public class CreateAccountRequest {
    private int accountType; //0 = CheckingAccount, 1 = SavingsAccount, 2 = CreditAccount
    private Long userId;
    private Long secondaryUserId;
    private String name;
    private BigDecimal balance;
    private String secretKey;
    private BigDecimal creditLimit;
    private double interestRate;
    private BigDecimal minimumBalance;
}
