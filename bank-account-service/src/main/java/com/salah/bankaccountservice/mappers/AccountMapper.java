package com.salah.bankaccountservice.mappers;


import com.salah.bankaccountservice.DTOs.AccountDTO;
import com.salah.bankaccountservice.entities.Account;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDTO mapAccount(Account account);
    List<AccountDTO> mapAccounts(List<Account> accounts);
}
