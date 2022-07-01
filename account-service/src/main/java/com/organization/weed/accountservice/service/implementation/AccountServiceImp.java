package com.organization.weed.accountservice.service.implementation;

import com.organization.weed.accountservice.converter.AccountConverter;
import com.organization.weed.accountservice.entity.Account;
import com.organization.weed.accountservice.entity.request.SaveAccountRequest;
import com.organization.weed.accountservice.exception.AccountAlreadyExistsException;
import com.organization.weed.accountservice.exception.NoAccountException;
import com.organization.weed.accountservice.repository.AccountRepository;
import com.organization.weed.accountservice.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImp implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImp(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account getAccountById(final Long id) throws NoAccountException {
        if(!accountRepository.existsById(id)) {
            throw new NoAccountException("There is no account with given id " + id);
        }
        return accountRepository.findById(id).get();
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public void save(final SaveAccountRequest request) throws AccountAlreadyExistsException {
        if(accountRepository.existsAccountByEmailOrNick(request.getEmail(), request.getNick())) {
            throw new AccountAlreadyExistsException("Account: " + request + " already exists");
        }

        accountRepository.save(AccountConverter.convertToAccount(request));
    }

    @Override
    public void deleteAccountById(Long id) throws NoAccountException {
        if(!accountRepository.existsById(id)) {
            throw new NoAccountException("Account with given id " + id + " does not exist!");
        }

        accountRepository.deleteById(id);
    }
}
