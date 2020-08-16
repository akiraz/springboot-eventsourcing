package com.akiraz.eventsourcingspringboot.services.commands;

import java.util.concurrent.CompletableFuture;

import com.akiraz.eventsourcingspringboot.dto.AccountCreateDTO;
import com.akiraz.eventsourcingspringboot.dto.MoneyCreditDTO;
import com.akiraz.eventsourcingspringboot.dto.MoneyDebitDTO;

public interface AccountCommandService {

	public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO);

	public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO);

	public CompletableFuture<String> createAccount(String accountNumber,AccountCreateDTO accountCreateDTO);

}
