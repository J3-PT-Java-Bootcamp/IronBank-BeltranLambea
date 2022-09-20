package com.ironhack.ironbank.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.ironbank.Account.Account;
import com.ironhack.ironbank.Account.CheckingAccount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "owner")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany (mappedBy = "primaryOwner")
            @JsonIgnore
    private List<Account> ownedAccounts;

    @OneToMany (mappedBy = "secondaryOwner")
    @JsonIgnore
    private List<CheckingAccount> secondaryOwnedAccounts;

    private String name;

    public User(String name) {
        this.name = name;
    }
}
