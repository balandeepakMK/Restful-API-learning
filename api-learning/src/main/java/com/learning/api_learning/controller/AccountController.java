package com.learning.api_learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.api_learning.model.Account;
import com.learning.api_learning.service.AccountService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    
    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account create(@RequestBody Account account){
        return accountService.createAccount(account);
    }
    
    @PostMapping("/{id}/deposit")
    public Account deposit(@PathVariable Long id, @RequestParam Double amount) {
        return accountService.deposit(id, amount);
    }
    
    @PostMapping("/{id}/withdraw")
    public Account withdraw(@PathVariable Long id, @RequestParam Double amount) {
        return accountService.withdraw(id, amount);
    }

    @GetMapping("/{id}")
    public Account getMethodName(@PathVariable Long id) {
        return accountService.getAccount(id);
    }   
}
