package com.akiraz.eventsourcingspringboot.commands;

public class CreditMoney extends BaseCommand {

	public final double amount;

	public CreditMoney(String id, double amount) {
		super(id);
		this.amount = amount;

	}
}
