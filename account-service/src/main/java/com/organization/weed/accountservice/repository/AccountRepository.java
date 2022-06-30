package com.organization.weed.accountservice.repository;

import com.organization.weed.accountservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsAccountByEmailOrNick(String email, String nick);
}
