package com.akiraz.eventsourcingspringboot.events;

public class AccountCreatedEvent extends BaseEvent {

	public final double accountBalance;

	public AccountCreatedEvent(String id, double balance) {
		super(id);
		this.accountBalance = balance;

	}
}
