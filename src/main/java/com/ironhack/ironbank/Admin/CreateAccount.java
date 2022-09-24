package com.ironhack.ironbank.Admin;

import com.ironhack.ironbank.Account.*;
import com.ironhack.ironbank.Request.CreateAccountRequest;
import com.ironhack.ironbank.User.AccountHolder;
import com.ironhack.ironbank.User.User;
import com.ironhack.ironbank.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateAccount {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;

    public Account run(CreateAccountRequest request) {
        Account account = null;

        int accountType = request.accountType();
        if (!userRepository.existsById(request.userId())) {
            System.out.println("There is no user with that ID, please try with a valid ID");
        }

        else {
            switch (accountType) {
                case 1 -> {
                    AccountHolder primaryUser = (AccountHolder) userRepository.findById(request.userId()).orElseThrow();
                        if (request.secondaryUserId() != null) {
                            if (!userRepository.existsById(request.secondaryUserId())) {
                                System.out.println("There is no secondary user with that ID, please try with a valid secondary user ID");
                            }
                            else {
                                AccountHolder secondaryUser = (AccountHolder) userRepository.findById(request.secondaryUserId()).orElseThrow();

                                //crear student account en función de la edad
                                if (primaryUser.getAge()<24){
                                    account = new StudentCheckingAccount(primaryUser, request.name(), request.secretKey(), secondaryUser);
                                    accountRepository.save(account);
                                } else {
                                    account = new NormalCheckingAccount(primaryUser, request.name(), request.secretKey(), secondaryUser);
                                    accountRepository.save(account);
                                }
                            }
                        }
                        else {
                            if (primaryUser.getAge()<24){
                                account = new StudentCheckingAccount(primaryUser, request.name(), request.secretKey());
                                accountRepository.save(account);
                            } else {
                                account = new NormalCheckingAccount(primaryUser, request.name(), request.secretKey());
                                accountRepository.save(account);
                            }
                        }
                }
                case 2 -> {
                    AccountHolder primaryUser = (AccountHolder) userRepository.findById(request.userId()).orElseThrow();
                    if (request.secondaryUserId() != null) {
                        if (!userRepository.existsById(request.secondaryUserId())) {
                            System.out.println("There is no secondary user with that ID, please try with a valid secondary user ID");
                        }
                        else {
                            AccountHolder secondaryUser = (AccountHolder) userRepository.findById(request.secondaryUserId()).orElseThrow();
                                account = new SavingsAccount(primaryUser, request.name(), request.secretKey(), secondaryUser);
                                accountRepository.save(account);
                        }
                    } else {
                        account = new SavingsAccount(primaryUser, request.name(), request.secretKey());
                        accountRepository.save(account);
                    }
                }
                case 3 -> {
                    AccountHolder primaryUser = (AccountHolder) userRepository.findById(request.userId()).orElseThrow();
                    if (request.secondaryUserId() != null) {

                        if (!userRepository.existsById(request.secondaryUserId())) {
                            System.out.println("There is no secondary user with that ID, please try with a valid secondary user ID");
                        }
                        else {
                            AccountHolder secondaryUser = (AccountHolder) userRepository.findById(request.secondaryUserId()).orElseThrow();
                            account = new CreditAccount(primaryUser, request.name(), request.secretKey(), secondaryUser);
                            accountRepository.save(account);
                        }
                    } else {
                        account = new CreditAccount(primaryUser, request.name(), request.secretKey());
                        accountRepository.save(account);
                    }

                }
                default -> throw new IllegalStateException("Unexpected value: " + accountType);
            }
        }

        return account;
    }
}
