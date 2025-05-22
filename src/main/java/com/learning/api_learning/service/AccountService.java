package com.learning.api_learning.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learning.api_learning.model.Account;
import com.learning.api_learning.repository.AccountRepository;


@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account){
        account.setBalance(account.getBalance() == null ? 0.0 : account.getBalance());
        return accountRepository.save(account);
    }

    public Account deposit (Long id, Double amount){
        Account account = getAccount(id);
        Double newBalance = account.getBalance() + amount;
        accountRepository.updateBalance(id, newBalance);
        account.setBalance(newBalance);
        return account;
    }

    public Account withdraw(Long id, Double amount){
        Account account = getAccount(id);
        if (account.getBalance() < amount){
            throw new RuntimeException("Insufficient funds");
        }
        Double newBalance = account.getBalance() - amount;
        accountRepository.updateBalance(id, newBalance);
        account.setBalance(newBalance);
        return account;
    }

    public Account getAccount(Long id){
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Account deleteAccount(Long id){
        Account account = getAccount(id);
        if (account != null){
            accountRepository.deleteById(id);
            return account;
        }
        return null;
    }
}
