package com.ironhack.ironbank.Admin;

import com.ironhack.ironbank.Request.CreateUserRequest;
import com.ironhack.ironbank.User.AccountHolder;
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
    void createUser_Test_type1(){
        LocalDate date = LocalDate.of(1980, 1, 8);
        Address address = new Address("Calle del Fresno");
        CreateUserRequest request = new CreateUserRequest(1, "Luis", date, address, "123");

        User user = createUser.run(request);
        userRepository.save(user);
        assertEquals(2, userRepository.findAll().size());
        System.out.println(user.getName());
    }

    @Test
    void createUser_Test_type1_ageLessThan24(){
        LocalDate date = LocalDate.of(2020, 1, 8);
        Address address = new Address("Calle del Fresno");
        CreateUserRequest request = new CreateUserRequest(1, "Peque", date, address, "123");

        User user = createUser.run(request);
        userRepository.save(user);
        assertEquals(1, userRepository.findAll().size());
        System.out.println(user.getName());
    }

    @Test
    void createUser_Test_type2(){
        LocalDate date = LocalDate.of(2020, 1, 8);
        Address address = new Address("Calle del Fresno");
        CreateUserRequest request = new CreateUserRequest(2, "Pepito", date, address, "123");

        User user = createUser.run(request);
        userRepository.save(user);
        assertEquals(3, userRepository.findAll().size());
        System.out.println(user.getName());
    }

    @Test
    void createUser_withFixedId(){
        LocalDate date = LocalDate.of(1744, 2, 23);
        Address address = new Address("Judengasse, Holy Roman Empire");
        User user = new AccountHolder(1744L, "Mayer Amschel Rothschild", date, address);
        userRepository.save(user);

        assertEquals("Mayer Amschel Rothschild", user.getName());
    }

}