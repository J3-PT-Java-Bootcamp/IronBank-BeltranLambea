package com.ironhack.ironbank.Account;

import com.ironhack.ironbank.Account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}