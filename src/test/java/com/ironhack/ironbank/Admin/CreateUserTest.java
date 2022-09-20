package com.ironhack.ironbank.Admin;

import com.ironhack.ironbank.Request.CreateUserRequest;
import com.ironhack.ironbank.User.Address;
import com.ironhack.ironbank.User.User;
import com.ironhack.ironbank.User.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreateUserTest {

    @Autowired
    CreateUser createUser;
    @Autowired
    UserRepository userRepository;

    @Test
    void createUser_Test(){
        LocalDate date = LocalDate.of(2020, 1, 8);
        Address address = new Address("Calle del Fresno");
        CreateUserRequest request = new CreateUserRequest(1, "Luis", date, address, "123");

        User user = createUser.run(request);
        userRepository.save(user);
        assertEquals(1, userRepository.findAll().size());
        System.out.println(user.getName());
    }

}