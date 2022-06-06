package com.email.EmailAppt;

import java.time.LocalDateTime;

public class Appointment extends EmailEntity {
    private Location location;
    public Appointment(int id, String from, String to, String subject, LocalDateTime timestamp, Location location) {
        super(id, from, to, subject, timestamp);

        this.location = location;
    }
}