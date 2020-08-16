package com.akiraz.eventsourcingspringboot.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import com.akiraz.eventsourcingspringboot.commands.CreateAccount;
import com.akiraz.eventsourcingspringboot.commands.CreditMoney;
import com.akiraz.eventsourcingspringboot.commands.DebitMoney;
import com.akiraz.eventsourcingspringboot.events.AccountCreatedEvent;
import com.akiraz.eventsourcingspringboot.events.MoneyCreditedEvent;
import com.akiraz.eventsourcingspringboot.events.MoneyDebitedEvent;

@Aggregate
public class AccountAggregate {

	@AggregateIdentifier
	private String id;

	private double accountBalance;

	public AccountAggregate() {
	}

	@CommandHandler
	public AccountAggregate(CreateAccount createAccountCommand) {
		AggregateLifecycle.apply(new AccountCreatedEvent(createAccountCommand.id, createAccountCommand.accountBalance));
	}

	@EventSourcingHandler
	protected void on(AccountCreatedEvent accountCreatedEvent) {
		this.id = accountCreatedEvent.id;
		this.accountBalance = accountCreatedEvent.accountBalance;

	}

	@CommandHandler
	protected void on(CreditMoney creditMoneyCommand) {
		AggregateLifecycle.apply(new MoneyCreditedEvent(creditMoneyCommand.id, creditMoneyCommand.amount));
	}

	@EventSourcingHandler
	protected void on(MoneyCreditedEvent moneyCreditedEvent) {

		this.accountBalance += moneyCreditedEvent.creditAmount;
	}

	@CommandHandler
	protected void on(DebitMoney debitMoneyCommand) {
		AggregateLifecycle.apply(new MoneyDebitedEvent(debitMoneyCommand.id, debitMoneyCommand.amount));
	}

	@EventSourcingHandler
	protected void on(MoneyDebitedEvent moneyDebitedEvent) {
		if (this.accountBalance >= 0 & (this.accountBalance - moneyDebitedEvent.amount) < 0) {
		}
		this.accountBalance -= moneyDebitedEvent.amount;

	}

}
