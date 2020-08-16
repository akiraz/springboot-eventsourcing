package com.akiraz.eventsourcingspringboot.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseCommand {

    @TargetAggregateIdentifier
    public final String id;

    public BaseCommand(String id) {
        this.id = id;
    }
}
