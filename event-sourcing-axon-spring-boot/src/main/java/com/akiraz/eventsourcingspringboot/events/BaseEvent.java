package com.akiraz.eventsourcingspringboot.events;

public class BaseEvent {

    public final String id;

    public BaseEvent(String id) {
        this.id = id;
    }
}
