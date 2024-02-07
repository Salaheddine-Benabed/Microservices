package com.salah.bankaccountservice.controllers;

import com.salah.bankaccountservice.DTOs.AccountDTO;
import com.salah.bankaccountservice.DTOs.AccountRequest;
import com.salah.bankaccountservice.services.AccountServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AccountController {
    private AccountServiceImpl accountService;

    @GetMapping("/accounts")
    private List<AccountDTO> getAccounts(){
        return accountService.getAllAccounts();
    }

    @PostMapping("/saveAccount")
    private AccountDTO saveAccount(@RequestBody AccountRequest account){
        return accountService.saveAccount(account);
    }

    @PutMapping("/{id}")
    private AccountDTO modifyAccount(@RequestBody AccountRequest account, @PathVariable("id") String id){
        return accountService.updateAccount(account, id);
    }
}
