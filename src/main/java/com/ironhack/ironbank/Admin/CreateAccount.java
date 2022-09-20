package com.ironhack.ironbank.Admin;

import com.ironhack.ironbank.Account.Account;
import com.ironhack.ironbank.Request.CreateAccountRequest;
import com.ironhack.ironbank.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateAccount {

    @Autowired
    UserRepository userRepository;

    private Account run(CreateAccountRequest request) {
        int accountType = request.getAccountType();
        if (!userRepository.existsById(request.getUserId())) {
            System.out.println("Hello");
        }

        Account account = null;
        switch (accountType) {
            case 0 -> System.out.println(1);
            case 1 -> System.out.println(2);
            case 2 -> System.out.println(3);
            default -> throw new IllegalStateException("Unexpected value: " + accountType);
        }

        return account;
    }
}
