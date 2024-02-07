package com.salah.bankaccountservice.services;

import com.salah.bankaccountservice.DTOs.AccountDTO;
import com.salah.bankaccountservice.DTOs.AccountRequest;

import java.util.List;

public interface IAccountService {
    List<AccountDTO> getAllAccounts();
    AccountDTO getAccountById(String id);
    AccountDTO saveAccount(AccountRequest account);
    AccountDTO updateAccount(AccountRequest account, String id);
}
