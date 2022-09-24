package com.ironhack.ironbank.Admin;

import com.ironhack.ironbank.Account.Account;
import com.ironhack.ironbank.Account.AccountRepository;
import com.ironhack.ironbank.Account.SavingsAccount;
import com.ironhack.ironbank.Request.CreateAccountRequest;
import com.ironhack.ironbank.Request.CreateUserRequest;
import com.ironhack.ironbank.User.Address;
import com.ironhack.ironbank.User.User;
import com.ironhack.ironbank.User.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreateAccountTest {

    @Autowired
    CreateAccount createAccount;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void createAccount_Test_type1_withSecondaryOwner(){
        CreateAccountRequest request = new CreateAccountRequest(1, 2L, 1L,
                "normalCheckingAccount con secondary user", "1234", null, null, null);

        Account account = createAccount.run(request);
        accountRepository.save(account);

        assertEquals(1, accountRepository.findAll().size());
        System.out.println(account.getPrimaryOwner().getName());
    }

    @Test
    void createAccount_Test_type1_withoutSecondaryOwner(){
        CreateAccountRequest request = new CreateAccountRequest(1, 2L, null,
                "normalCheckingAccount sin secondary user", "1234", null, null, null);

        Account account = createAccount.run(request);
        accountRepository.save(account);

        assertEquals(2, accountRepository.findAll().size());
        System.out.println(account.getPrimaryOwner().getName());
    }

    @Test
    void createAccount_Test_type1_withSecondaryOwner_ageLessThan24(){
        CreateAccountRequest request = new CreateAccountRequest(1, 1L, 2L,
                "studentCheckingAccount con secondary user", "1234", null, null, null);

        Account account = createAccount.run(request);
        accountRepository.save(account);

        assertEquals(3, accountRepository.findAll().size());
        System.out.println(account.getPrimaryOwner().getName());
    }

    @Test
    void createAccount_Test_type1_withoutSecondaryOwner_ageLessThan24(){
        CreateAccountRequest request = new CreateAccountRequest(1, 1L, null,
                "studentCheckingAccount sin secondary user", "1234", null, null, null);

        Account account = createAccount.run(request);
        accountRepository.save(account);

        assertEquals(4, accountRepository.findAll().size());
        System.out.println(account.getPrimaryOwner().getName());
    }

    @Test
    void createAccount_Test_type2_withoutSecondaryOwner(){
        CreateAccountRequest request = new CreateAccountRequest(2, 1L, null,
                "SavingsAccount sin secondary user", "1234", null, null, null);

        Account account = createAccount.run(request);
        accountRepository.save(account);

        assertEquals(5, accountRepository.findAll().size());
        System.out.println(account.getPrimaryOwner().getName());

    }

    @Test
    void createAccount_Test_type2_withSecondaryOwner(){
        CreateAccountRequest request = new CreateAccountRequest(2, 1L, 2L,
                "savings account con secondary user", "1234", null, null, null);

        Account account = createAccount.run(request);
        accountRepository.save(account);

        assertEquals(8, accountRepository.findAll().size());
        System.out.println(account.getPrimaryOwner().getName());
    }

    @Test
    void createAccount_Test_type3_withoutSecondaryOwner(){
        CreateAccountRequest request = new CreateAccountRequest(3, 1L, null,
                "CreditAccount sin secondary user", "1234", null, null, null);

        Account account = createAccount.run(request);
        accountRepository.save(account);

        assertEquals(6, accountRepository.findAll().size());
        System.out.println(account.getPrimaryOwner().getName());

    }

    @Test
    void createAccount_Test_type3_withSecondaryOwner(){
        CreateAccountRequest request = new CreateAccountRequest(3, 1L, 2L,
                "CreditAccount con secondary user", "1234", null, null, null);

        Account account = createAccount.run(request);
        accountRepository.save(account);

        assertEquals(7, accountRepository.findAll().size());
        System.out.println(account.getPrimaryOwner().getName());
    }


}