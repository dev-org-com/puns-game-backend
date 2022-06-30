package com.organization.weed.accountservice.entity;

import javax.persistence.*;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 25)
    private String nick;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 25)
    private String password;

    public Account() {
    }

    public Account(Long id, String nick, String email, String password) {
        this.id = id;
        this.nick = nick;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
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
                ", nick='" + nick + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
