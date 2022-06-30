package com.organization.weed.accountservice.entity.request;

import javax.validation.constraints.NotNull;

public class SaveAccountRequest {

    @NotNull
    private String nick;

    @NotNull
    private String email;

    @NotNull
    private String password;

    public SaveAccountRequest() {
    }

    public SaveAccountRequest(String nick, String email, String password) {
        this.nick = nick;
        this.email = email;
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "nick='" + nick + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
