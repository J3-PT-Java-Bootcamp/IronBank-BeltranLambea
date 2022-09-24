package com.ironhack.ironbank.Money;

import com.ironhack.ironbank.Account.Account;
import com.ironhack.ironbank.Account.AccountRepository;
import com.ironhack.ironbank.Request.TransactionRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionTest {
    @Autowired
    Transaction transaction;

    @Autowired
    AccountRepository accountRepository;

    @Test
    void run_validTransaction_withPrimaryOwnerName() {
        TransactionRequest request = new TransactionRequest(1L, 3L, BigDecimal.valueOf(100), "1234",
                "Peque");
        transaction.run(request);

        BigDecimal a = BigDecimal.valueOf(400);
        Account account = accountRepository.findById(3L).orElseThrow();

        assertEquals(a.stripTrailingZeros(), account.getBalance().stripTrailingZeros());
    }

    @Test
    void run_validTransaction_withSecondaryOwnerName() {
        TransactionRequest request = new TransactionRequest(3L, 1L, BigDecimal.valueOf(100), "1234",
                "Luis");
        transaction.run(request);

        BigDecimal a = BigDecimal.valueOf(300);
        Account account = accountRepository.findById(1L).orElseThrow();

        assertEquals(a.stripTrailingZeros(), account.getBalance().stripTrailingZeros());
    }
}