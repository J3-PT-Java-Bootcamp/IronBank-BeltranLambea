package com.ironhack.ironbank.Admin;

import com.ironhack.ironbank.Account.Account;
import com.ironhack.ironbank.Account.AccountRepository;
import com.ironhack.ironbank.Account.Status;
import com.ironhack.ironbank.Money.AddMoney;
import com.ironhack.ironbank.Money.Transaction;
import com.ironhack.ironbank.Request.CreateAccountRequest;
import com.ironhack.ironbank.Request.CreateUserRequest;
import com.ironhack.ironbank.Request.TransactionRequest;
import com.ironhack.ironbank.User.User;
import com.ironhack.ironbank.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImplemented implements AdminService{
    @Autowired
    CreateUser createUser;
    @Autowired
    CreateAccount createAccount;
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    Transaction transaction;

    @Autowired
    AddMoney addMoney;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public String createUser(CreateUserRequest request) {
        User user = createUser.run(request);
        return "User: " + user.toString() + " created successfully";
    }

    @Override
    public String createAccount(CreateAccountRequest request) {
        Account account = createAccount.run(request);
        return account.toString();
    }

    @Override
    public String checkBalance(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        return String.valueOf(account.getBalance());
    }

    @Override
    public String modifyBalance(TransactionRequest request) {
        Account account = accountRepository.findById(request.senderAccountId()).orElseThrow();
        User user = account.getPrimaryOwner();
        transaction.run(request);
        return "Balance of account :" + account.getName() +  " modified as requested. That account is owned by : " +
                user.getName();
    }

    @Override
    public String addMoney(Long accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        User user = account.getPrimaryOwner();

        addMoney.run(accountId, amount);
        return "Balance of account :" + account.getName() +  " modified as requested. That account is owned by : " +
                user.getName();
    }

    @Override
    public String freezeAccount(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        User user = account.getPrimaryOwner();

        account.setStatus(Status.FROZEN);
        accountRepository.save(account);
        return "Account :" + account.getName() +  " has been frozen. That account is owned by : " +
                user.getName();
    }

    @Override
    public String deleteAccount(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        User user = account.getPrimaryOwner();

        Account mainAccount = accountRepository.findById(1744L).orElseThrow();
        mainAccount.setBalance(mainAccount.getBalance().add(account.getBalance()));

        accountRepository.deleteById(accountId);
        accountRepository.save(mainAccount);
        return "Account :" + account.getName() +  " has been deleted. That account was owned by : " +
                user.getName();
    }

    @Override
    public Optional<Account> getById(Long id) {
        return accountRepository.findById(id);
    }
}
