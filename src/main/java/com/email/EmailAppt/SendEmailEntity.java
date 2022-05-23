package com.email.EmailAppt;

import com.email.App.HikariCPDataSource;
import com.email.Users.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class SendEmailEntity {
    static int count = 2;
    public static void CreateNew(emailAppt type, User user) {
        if(type == emailAppt.Email) {
            CreateEmail(user, count);
        } else if(type == emailAppt.Appointment) {
            CreateAppt();
        }

    }

    private static void CreateEmail(User user, int count) {

        Scanner input = new Scanner (System.in);
        System.out.print("Send email to: ");
        String to = input.nextLine();
        System.out.print("Subject: ");
        String subject = input.nextLine();
        System.out.println("Body: ");
        String body = input.nextLine();
        Email newEmail = new Email(count, user.getEmail(), to, subject, body, LocalDateTime.now(), false);
        SendEmail(user, count, newEmail);
    }

    private static void SendEmail(User user, int count, Email email) {
        // Email newMail = new Email(count, "xiaohua@company.com", "xiaoming@company.com", "RE: Please check", "Hi, I have checked that it is correct.", LocalDateTime.now(), false);
        String SQL = "INSERT INTO email " + "VALUES (?,?,?,?,?,?,?)";
        try (Connection con = HikariCPDataSource.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(SQL);
            stmt.setInt(1, email.getId());
            stmt.setString(2, email.getFrom());
            stmt.setString(3, email.getTo());
            stmt.setString(4, email.getSubject());
            stmt.setString(5, email.getBody());
            stmt.setTimestamp(6, Timestamp.valueOf(email.getTimestamp()));
            stmt.setBoolean(7, email.getIsArchived());
            int updated = stmt.executeUpdate();
            System.out.println("Email sent successfully!");
            count++;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void CreateAppt() {

    }
}
