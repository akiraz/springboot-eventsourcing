package com.akiraz.eventsourcingspringboot.commands;

public class CreateAccount extends BaseCommand {

	public final double accountBalance;

	public CreateAccount(String id, double accountBalance) {
		super(id);
		this.accountBalance = accountBalance;
	}
}
