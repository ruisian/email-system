package com.email.EmailAppt;

import java.time.ZonedDateTime;

public class Email extends EmailEntity {
    private boolean isArchived;
    private String body;

    public Email(int id, String from, String to, String subject, String body, ZonedDateTime timestamp, boolean isArchived) {
        super(id, from, to, subject, timestamp);

        this.isArchived = isArchived;
    }
}
