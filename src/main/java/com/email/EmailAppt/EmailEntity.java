package com.email.EmailAppt;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public abstract class EmailEntity {
    private int id;
    private String from;
    private String to;
    private String subject;
    private LocalDateTime timestamp;

    public EmailEntity (int id, String from, String to, String subject, LocalDateTime timestamp) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.timestamp = timestamp;
    }


    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}



