package com.akiraz.eventsourcingspringboot.services.commands;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.akiraz.eventsourcingspringboot.commands.CreateAccount;
import com.akiraz.eventsourcingspringboot.commands.CreditMoney;
import com.akiraz.eventsourcingspringboot.commands.DebitMoney;
import com.akiraz.eventsourcingspringboot.dto.AccountCreateDTO;
import com.akiraz.eventsourcingspringboot.dto.MoneyCreditDTO;
import com.akiraz.eventsourcingspringboot.dto.MoneyDebitDTO;

@Service
public class AccountCommandServiceImpl implements AccountCommandService {

    private final CommandGateway commandGateway;

    public AccountCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    
    @Override
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO) {
        return commandGateway.send(new CreditMoney(accountNumber, moneyCreditDTO.getAmount()));
    }

    @Override
    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO) {
        return commandGateway.send(new DebitMoney(accountNumber, moneyDebitDTO.getAmount()));
    }

    @Override
    public CompletableFuture<String> createAccount(String accountNumber,AccountCreateDTO accountCreateDTO) {
        return commandGateway.send(new CreateAccount(accountNumber, accountCreateDTO.getBalance()));
    }

   
}
