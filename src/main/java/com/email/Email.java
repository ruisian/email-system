package com.email;

import java.time.ZonedDateTime;

public abstract class Email {
    private int id;
    private int from;
    private int to;
    private String subject;
    private ZonedDateTime timestamp;
    private int location_id;
    private String body;
    private boolean isarchive;

    public class Location {
        private int id;
        private String name;
    }

    public class EmailArchive {
        private int id;
        private int email_id;
    }

    //email
    public Email (int id, int from, int to, String subject, String body, ZonedDateTime timestamp, boolean isarchive) {

    }

    //appointment
    public Email (int id, int from, int to, String subject, ZonedDateTime timestamp, int location_id) {
    }

}
