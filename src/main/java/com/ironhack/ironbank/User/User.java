package com.ironhack.ironbank.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.ironbank.Account.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "owner")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany (mappedBy = "primaryOwner")
            @JsonIgnore
    private List<Account> ownedAccounts;
}
