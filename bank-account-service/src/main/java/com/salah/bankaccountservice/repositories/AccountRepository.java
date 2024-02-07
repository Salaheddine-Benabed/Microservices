package com.salah.bankaccountservice.repositories;

import com.salah.bankaccountservice.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
