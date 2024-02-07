package com.salah.bankaccountservice.services;

import com.salah.bankaccountservice.DTOs.AccountDTO;
import com.salah.bankaccountservice.DTOs.AccountRequest;
import com.salah.bankaccountservice.entities.Account;
import com.salah.bankaccountservice.mappers.AccountMapper;
import com.salah.bankaccountservice.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    @Override
    public List<AccountDTO> getAllAccounts() {
        return accountMapper.mapAccounts(accountRepository.findAll());
    }

    @Override
    public AccountDTO getAccountById(String id) {
        return accountMapper.mapAccount(accountRepository.findById(id).get());
    }

    @Override
    public AccountDTO saveAccount(AccountRequest accountRequest) {
        Account account = Account.builder()
                .id(UUID.randomUUID().toString())
                .balance(accountRequest.getBalance())
                .createdAt(accountRequest.getCreatedAt())
                .currency(accountRequest.getCurrency())
                .build();
        return accountMapper.mapAccount(accountRepository.save(account));
    }

    @Override
    public AccountDTO updateAccount(AccountRequest account, String id) {
        Account toModify = accountRepository.findById(id).get();
        toModify.setBalance(account.getBalance());
        toModify.setCurrency(account.getCurrency());
        toModify.setCreatedAt(account.getCreatedAt());
        return accountMapper.mapAccount(accountRepository.save(toModify));
    }
}
