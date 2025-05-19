package com.learning.api_learning.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learning.api_learning.model.Account;

@Repository
public class AccountRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Account save(Account account){
        String sql = "INSERT INTO accounts (account_holder, balance) VALUES(?, ?)";
        jdbcTemplate.update(sql, account.getAccountHolder(), account.getBalance());
        return account;
    }

    public Optional<Account> findById(Long id){
        String sql = "SELECT * FROM accounts WHERE id = ?";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Account.class), id).stream().findFirst();
    }

    public int updateBalance(Long id, Double newBalance){
        String sql = "UPDATE accounts SET balance = ? Where id = ?";
        return jdbcTemplate.update(sql, newBalance, id);
    }
}
