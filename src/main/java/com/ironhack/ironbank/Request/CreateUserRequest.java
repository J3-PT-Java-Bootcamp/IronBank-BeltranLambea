package com.ironhack.ironbank.Request;

import com.ironhack.ironbank.User.Address;


import java.time.LocalDate;


public record CreateUserRequest (
        int userType, //1 = AccountHolder, 2 = ThirdParty
        String name,
        LocalDate dateOfBirth,
        Address address,
        String hashedKey
)
{
}
