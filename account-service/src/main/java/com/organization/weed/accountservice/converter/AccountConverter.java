package com.organization.weed.accountservice.converter;

import com.organization.weed.accountservice.entity.Account;
import com.organization.weed.accountservice.entity.request.SaveAccountRequest;

import java.util.Optional;

public class AccountConverter {
    private AccountConverter() { }

    public static Account convertToAccount(SaveAccountRequest request) {
        return Optional.ofNullable(request).map(req-> {
            return new Account(null, req.getNick(), req.getEmail(), req.getPassword());
        }).orElse(null);
    }
}
