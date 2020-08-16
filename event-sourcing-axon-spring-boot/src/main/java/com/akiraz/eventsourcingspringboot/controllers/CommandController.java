package com.akiraz.eventsourcingspringboot.controllers;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akiraz.eventsourcingspringboot.dto.AccountCreateDTO;
import com.akiraz.eventsourcingspringboot.dto.MoneyCreditDTO;
import com.akiraz.eventsourcingspringboot.dto.MoneyDebitDTO;
import com.akiraz.eventsourcingspringboot.services.commands.AccountCommandService;

@RestController
@RequestMapping(value = "/accounts")
public class CommandController {

    private final AccountCommandService accountCommandService;

    public CommandController(AccountCommandService accountCommandService) {
        this.accountCommandService = accountCommandService;
    }

    @PostMapping(value = "/credits/{accountNumber}")
    public CompletableFuture<String> createAccount(@PathVariable(value = "accountNumber") String accountNumber,@RequestBody AccountCreateDTO accountCreateDTO){
        return accountCommandService.createAccount(accountNumber,accountCreateDTO);
    }

    @PutMapping(value = "/credits/{accountNumber}")
    public CompletableFuture<String> creditMoneyToAccount(@PathVariable(value = "accountNumber") String accountNumber,
                                                          @RequestBody MoneyCreditDTO moneyCreditDTO){
        return accountCommandService.creditMoneyToAccount(accountNumber, moneyCreditDTO);
    }

    @PutMapping(value = "/debits/{accountNumber}")
    public CompletableFuture<String> debitMoneyFromAccount(@PathVariable(value = "accountNumber") String accountNumber,
                                                           @RequestBody MoneyDebitDTO moneyDebitDTO){
        return accountCommandService.debitMoneyFromAccount(accountNumber, moneyDebitDTO);
    }
}
