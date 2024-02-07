package com.salah.bankaccountservice.controllers;

import com.salah.bankaccountservice.DTOs.AccountDTO;
import com.salah.bankaccountservice.DTOs.AccountRequest;
import com.salah.bankaccountservice.entities.Account;
import com.salah.bankaccountservice.mappers.AccountMapper;
import com.salah.bankaccountservice.repositories.AccountRepository;
import com.salah.bankaccountservice.services.AccountServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class graphController {
    private AccountRepository accountRepository;
    private AccountServiceImpl accountService;

    @QueryMapping
    public List<Account> accountsList(){
        return accountRepository.findAll();
    }
    @QueryMapping
    public Account accountById(@Argument String id){
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("This account %s doesn't exist",id)));
    }
    @MutationMapping
    public AccountDTO saveAccount(@Argument AccountRequest accountRequest) {
        return accountService.saveAccount(accountRequest);
    }
    @MutationMapping
    public AccountDTO updateAccount(@Argument String id, @Argument AccountRequest accountRequest) {
        return accountService.updateAccount(accountRequest, id);
    }
    @MutationMapping
    public AccountDTO deleteAccount (@Argument String id) {
        Account a =  accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("This account %s doesn't exist",id)));
        accountRepository.delete(a);
        return AccountMapper.INSTANCE.mapAccount(a);
    }
}
