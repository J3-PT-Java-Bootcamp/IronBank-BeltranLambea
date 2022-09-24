package com.ironhack.ironbank.Account;

import com.ironhack.ironbank.User.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CheckingAccount extends Account{
    private String secretKey;
    @ManyToOne
    @JoinColumn(name = "secondaryOwner_id")
    private User secondaryOwner;

    public CheckingAccount(User primaryOwner, String name, String secretKey, User secondaryOwner) {
        super(primaryOwner, name);
        this.secretKey = secretKey;
        this.secondaryOwner = secondaryOwner;
    }

    public CheckingAccount(User primaryOwner, String name, String secretKey) {
        super(primaryOwner, name);
        this.secretKey = secretKey;
    }



















}
