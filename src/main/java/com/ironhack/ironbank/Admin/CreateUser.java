package com.ironhack.ironbank.Admin;

import com.ironhack.ironbank.Request.CreateUserRequest;
import com.ironhack.ironbank.User.AccountHolder;
import com.ironhack.ironbank.User.ThirdParty;
import com.ironhack.ironbank.User.User;
import com.ironhack.ironbank.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    @Autowired
    UserRepository userRepository;

    public User run(CreateUserRequest request){
        int userType = request.userType();
        User user;

        switch(userType) {
            case 1 -> user = new AccountHolder(request.name(), request.dateOfBirth(), request.address());
            case 2 -> user = new ThirdParty(request.name(), request.hashedKey());
            default -> throw new IllegalStateException("Unexpected value: " + userType);
        }
        return user;
    }
}
