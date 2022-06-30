package com.organization.weed.accountservice.exception;

public class AccountAlreadyExistsException extends Exception{
    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}
