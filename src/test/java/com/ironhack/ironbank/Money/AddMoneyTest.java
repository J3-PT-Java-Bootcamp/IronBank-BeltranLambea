package com.ironhack.ironbank.Money;

import com.ironhack.ironbank.Account.Account;
import com.ironhack.ironbank.Account.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddMoneyTest {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AddMoney addMoney;

    @Test
    void run() {
        addMoney.run(1L, BigDecimal.valueOf(400));
        Account account = accountRepository.findById(1L).orElseThrow();
        BigDecimal a = BigDecimal.valueOf(400);

        assertEquals(a.stripTrailingZeros(), account.getBalance().stripTrailingZeros());
    }
}