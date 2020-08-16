package com.akiraz.eventsourcingspringboot.events;

public class MoneyCreditedEvent extends BaseEvent {

	public final double creditAmount;

	public MoneyCreditedEvent(String id, double amount) {
		super(id);
		this.creditAmount = amount;
	}
}
