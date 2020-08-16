package com.akiraz.eventsourcingspringboot.events;

public class MoneyDebitedEvent extends BaseEvent {

	public final double amount;

	public MoneyDebitedEvent(String id, double amount) {
		super(id);
		this.amount = amount;

	}
}
