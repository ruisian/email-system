package com.email.EmailAppt;

import java.time.ZonedDateTime;

public abstract class EmailEntity {
    private int id;
    private String from;
    private String to;
    private String subject;
    private ZonedDateTime timestamp;

    public EmailEntity (int id, String from, String to, String subject, ZonedDateTime timestamp) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.timestamp = timestamp;
    }





}



