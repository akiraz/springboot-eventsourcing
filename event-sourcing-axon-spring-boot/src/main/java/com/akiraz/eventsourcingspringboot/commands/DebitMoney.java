package com.akiraz.eventsourcingspringboot.commands;

public class DebitMoney extends BaseCommand {

	public final double amount;

	public DebitMoney(String id, double amount) {
		super(id);
		this.amount = amount;

	}
}
