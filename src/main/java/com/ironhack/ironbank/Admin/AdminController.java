package com.ironhack.ironbank.Admin;

import com.ironhack.ironbank.Account.Account;
import com.ironhack.ironbank.Request.CreateAccountRequest;
import com.ironhack.ironbank.Request.CreateUserRequest;
import com.ironhack.ironbank.Request.TransactionRequest;
import com.ironhack.ironbank.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return adminService.getAll();
    }

    @PostMapping("/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(@RequestBody CreateUserRequest request) {
        return adminService.createUser(request);
    }

    @PostMapping("/createAccount")
    @ResponseStatus(HttpStatus.CREATED)
    public String createAccount(@RequestBody CreateAccountRequest request) {
        return adminService.createAccount(request);
    }

    @GetMapping("/balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getBalance(@PathVariable Long id) {
        return adminService.checkBalance(id);
    }

    @PostMapping("/modifyBalance")
    @ResponseStatus(HttpStatus.CREATED)
    public String modifyBalance(@RequestBody TransactionRequest request) {
        return adminService.modifyBalance(request);
    }

    @PatchMapping("/addMoney/{id}/{amount}")
    @ResponseStatus(HttpStatus.CREATED)
    public String addMoney(@PathVariable Long id, @PathVariable BigDecimal amount) {
        return adminService.addMoney(id, amount);
    }

    @PatchMapping("/freezeAccount/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String modifyStatus(@PathVariable Long id){
        return adminService.freezeAccount(id);
    }

    @DeleteMapping("/deleteAccount/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteAccount(@PathVariable Long id){
        return adminService.deleteAccount(id);
    }

}
