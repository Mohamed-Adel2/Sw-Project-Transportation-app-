package com.example.demoProjectWebService.application;

import java.sql.Time;
import java.time.LocalTime;

public class Event {

    private String name;
    private Time time;

    public Event(String name) {
        this.name = name;
        this.time = Time.valueOf(LocalTime.now());
    }

    public String getName() {
        return name;
    }

    public Time getTime() {
        return time;
    }

}