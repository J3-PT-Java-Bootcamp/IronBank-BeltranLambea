package com.ironhack.ironbank.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

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
    }
}
