package com.ironhack.ironbank.User;

import com.ironhack.ironbank.Admin.AdminService;
import com.ironhack.ironbank.Request.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/owners")
public class UserController {

    @Autowired
    UserService userService;

//    String checkBalance(Long accountId);
//    String performTransaction(TransactionRequest request);

    @GetMapping("/balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getBalance(@PathVariable Long id) {
        return userService.checkBalance(id);
    }

    @PostMapping("/performTransaction")
    @ResponseStatus(HttpStatus.CREATED)
    public String modifyBalance(@RequestBody TransactionRequest request) {
        return userService.performTransaction(request);
    }
}
