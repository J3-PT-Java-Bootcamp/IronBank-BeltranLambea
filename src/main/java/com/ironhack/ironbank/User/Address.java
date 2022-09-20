package com.ironhack.ironbank.User;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    private String address;

    @OneToOne(mappedBy = "address")
    private AccountHolder addressOwner;

    public Address(String address) {
        this.address = address;
    }
}
