package com.learning.api_learning;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.learning.api_learning.controller.AccountController;
import com.learning.api_learning.model.Account;
import com.learning.api_learning.service.AccountService;

public class AccountControllerTest {
    
    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    private Account account;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        account = new Account();
        account.setId(1L);
        account.setAccountHolder("John Doe");
        account.setBalance(1000.0);
    }

    @Test
    public void testCreateAccount() {
        when(accountService.createAccount(account)).thenReturn(account);
    }

    @Test
    public void testDeposit() {
        when(accountService.deposit(1L, 500.0)).thenReturn(account);
    }

    @Test
    public void testWithdraw() {
        when(accountService.withdraw(1L, 200.0)).thenReturn(account);
    }

    @Test
    public void testGetAccount() {
        when(accountService.getAccount(1L)).thenReturn(account);
    }
}
