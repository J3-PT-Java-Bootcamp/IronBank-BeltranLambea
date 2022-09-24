package com.ironhack.ironbank.Request;



import java.math.BigDecimal;

public record CreateAccountRequest (
        int accountType, //1 = CheckingAccount, 2 = SavingsAccount, 3 = CreditAccount
        Long userId,
        Long secondaryUserId,
        String name,
        String secretKey,
        BigDecimal creditLimit, //solo se usa en CreditAccount
        Double interestRate, //solo se usa en CreditAccount
        BigDecimal minimumBalance
)
{
}
