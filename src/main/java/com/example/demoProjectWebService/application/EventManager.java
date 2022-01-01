package com.example.demoProjectWebService.application;

import java.util.ArrayList;

public class EventManager {

    private ArrayList<EventListener> listeners = new ArrayList<>();

    public void subscribe(EventListener listener) {
        listeners.add(listener);
    }

    public void unsubscribe(EventListener listener) {
        listeners.remove(listener);
    }

    public void notify(Event event, Ride ride) {
        for (EventListener listener : listeners) {
            listener.update(event, ride);
        }
    }
}
