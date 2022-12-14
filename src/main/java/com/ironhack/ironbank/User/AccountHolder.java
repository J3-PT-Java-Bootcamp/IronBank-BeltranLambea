package com.ironhack.ironbank.User;

import com.ironhack.ironbank.Account.Account;
import com.ironhack.ironbank.Account.CheckingAccount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class AccountHolder extends User{
    private LocalDate dateOfBirth;
    private int age;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "main_address",
            joinColumns = @JoinColumn(name = "account_holder_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Address address;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "mailing_address",
            joinColumns = @JoinColumn(name = "account_holder_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Address mailingAddress;

    public AccountHolder(String name, LocalDate dateOfBirth, Address address) {
        super(name);
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        LocalDate actualDate = LocalDate.now();
        this.age = dateOfBirth.until(actualDate).getYears();
    }

    public AccountHolder(Long id,  String name, LocalDate dateOfBirth, Address address) {
        super(id, name);
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        LocalDate actualDate = LocalDate.now();
        this.age = dateOfBirth.until(actualDate).getYears();
    }


}
