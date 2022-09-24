package com.ironhack.ironbank.Money;
import com.ironhack.ironbank.Account.AccountRepository;
import com.ironhack.ironbank.Account.CheckingAccount;
import com.ironhack.ironbank.Account.Status;
import com.ironhack.ironbank.Request.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Transaction {
    @Autowired
    AccountRepository accountRepository;


    public void run(TransactionRequest request) {
        CheckingAccount senderAccount = (CheckingAccount) accountRepository.findById(request.senderAccountId()).orElseThrow();
        CheckingAccount receiverAccount = (CheckingAccount) accountRepository.findById(request.receiverAccountId()).orElseThrow();

        if (senderAccount.getStatus()== Status.FROZEN) {
            System.out.println("Sender account is frozen, can't perform transaction");
        } else if (receiverAccount.getStatus()== Status.FROZEN) {
            System.out.println("Receiver account is frozen, can't perform transaction");
        } else {
            if (senderAccount.getBalance().compareTo(request.amount()) < 0) {
                System.out.println("Sender account has not enough funds, can't perform transaction");
            } else {
                if (!senderAccount.getSecretKey().equals(request.transactionSecretKey())) {
                    System.out.println("Incorrect secretKey, can't perform transaction");
                } else {
                    if (!(receiverAccount.getPrimaryOwner().getName().equals(request.receiverName()) || receiverAccount.getSecondaryOwner().getName().equals(request.receiverName()))) {
                        System.out.println("Incorrect receiverName, can't perform transaction");
                    } else {
                        senderAccount.setBalance(senderAccount.getBalance().subtract(request.amount()));
                        receiverAccount.setBalance(receiverAccount.getBalance().add(request.amount()));

                        accountRepository.save(senderAccount);
                        accountRepository.save(receiverAccount);

                        System.out.println("Transaction successful");
                    }
                }
            }
        }
    }
}
