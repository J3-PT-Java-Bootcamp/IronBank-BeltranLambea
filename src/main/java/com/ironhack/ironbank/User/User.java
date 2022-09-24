package com.ironhack.ironbank.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.ironbank.Account.Account;
import com.ironhack.ironbank.Account.CheckingAccount;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "owner")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @OneToMany (mappedBy = "primaryOwner")
            @JsonIgnore
    @ToString.Exclude
    private List<Account> ownedAccounts;

    @OneToMany (mappedBy = "secondaryOwner")
    @JsonIgnore
    @ToString.Exclude
    private List<CheckingAccount> secondaryOwnedAccounts;

    private String name;

    public User(String name) {
        this.name = name;
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }


}
