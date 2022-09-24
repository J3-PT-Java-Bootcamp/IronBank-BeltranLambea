package com.ironhack.ironbank.Account;

import com.ironhack.ironbank.User.User;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class StudentCheckingAccount extends CheckingAccount{

    public StudentCheckingAccount(User primaryOwner, String name, String secretKey, User secondaryOwner) {
        super(primaryOwner, name, secretKey, secondaryOwner);
    }

    public StudentCheckingAccount(User primaryOwner, String name, String secretKey) {
        super(primaryOwner, name, secretKey);
    }
}
