package com.ironhack.ironbank.User;

import com.ironhack.ironbank.Account.Account;
import com.ironhack.ironbank.Account.AccountRepository;
import com.ironhack.ironbank.Money.Transaction;
import com.ironhack.ironbank.Request.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplemented implements UserService{

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    Transaction transaction;

    @Override
    public String checkBalance(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        return String.valueOf(account.getBalance());
    }

    @Override
    public String performTransaction(TransactionRequest request) {
        Account senderAccount = accountRepository.findById(request.senderAccountId()).orElseThrow();
        Account receiverAccount = accountRepository.findById(request.senderAccountId()).orElseThrow();

        transaction.run(request);
        return "Performed transaction request from: " + senderAccount.getName() + " to: " + receiverAccount.getName();
    }
}
