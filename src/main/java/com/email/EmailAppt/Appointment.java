package com.email.EmailAppt;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Appointment extends EmailEntity {
    private location location;
    public Appointment(int id, String from, String to, String subject, LocalDateTime timestamp, com.email.EmailAppt.location location) {
        super(id, from, to, subject, timestamp);

        this.location = location;
    }
}