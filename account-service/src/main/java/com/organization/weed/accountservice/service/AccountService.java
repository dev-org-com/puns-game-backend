package com.organization.weed.accountservice.service;

import com.organization.weed.accountservice.entity.Account;
import com.organization.weed.accountservice.entity.request.SaveAccountRequest;
import com.organization.weed.accountservice.exception.AccountAlreadyExistsException;
import com.organization.weed.accountservice.exception.NoAccountException;

import java.util.List;


public interface AccountService {
    Account getAccountById(Long id) throws NoAccountException;
    List<Account> getAllAccounts();
    void save(SaveAccountRequest request) throws AccountAlreadyExistsException;
    void deleteAccountById(Long id) throws NoAccountException;
}
