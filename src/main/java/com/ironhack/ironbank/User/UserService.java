package com.ironhack.ironbank.User;

import com.ironhack.ironbank.Request.TransactionRequest;

import java.util.List;

public interface UserService {

    String checkBalance(Long accountId);
    String performTransaction(TransactionRequest request);
}
