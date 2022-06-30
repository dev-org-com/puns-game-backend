package com.organization.weed.accountservice.controller;

import com.organization.weed.accountservice.entity.Account;
import com.organization.weed.accountservice.entity.request.SaveAccountRequest;
import com.organization.weed.accountservice.exception.AccountAlreadyExistsException;
import com.organization.weed.accountservice.exception.NoAccountException;
import com.organization.weed.accountservice.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/account-service")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        try {
            return accountService.getAccountById(id);
        } catch(NoAccountException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid SaveAccountRequest request) {
        try {
            accountService.save(request);
        } catch (AccountAlreadyExistsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
