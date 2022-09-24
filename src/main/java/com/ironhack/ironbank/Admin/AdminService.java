package com.ironhack.ironbank.Admin;

import com.ironhack.ironbank.Account.Account;
import com.ironhack.ironbank.Request.CreateAccountRequest;
import com.ironhack.ironbank.Request.CreateUserRequest;
import com.ironhack.ironbank.Request.TransactionRequest;
import com.ironhack.ironbank.User.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AdminService {

    List<User> getAll();
    String createUser(CreateUserRequest request);
    String createAccount(CreateAccountRequest request);
    String checkBalance(Long accountId);
    String modifyBalance(TransactionRequest request);

    String addMoney(Long accountId, BigDecimal amount);
    String freezeAccount(Long accountId);
    String deleteAccount(Long accountId);

    Optional<Account> getById(Long id);
}
