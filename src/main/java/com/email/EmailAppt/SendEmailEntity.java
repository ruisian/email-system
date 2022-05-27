package com.email.EmailAppt;

import com.email.app.HikariCPDataSource;
import com.email.Users.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class SendEmailEntity {
    static int emailCount = 2;
    //static int appointmentCount = 0;
    public static void createNew(EmailAppt type, User user) {
        if(type == EmailAppt.Email) {
            emailCount = createEmail(user, emailCount);
        } else if(type == EmailAppt.Appointment) {
            createAppt();
        }

    }

    private static int createEmail(User user, int count) {

        Scanner input = new Scanner (System.in);
        System.out.print("Send email to: ");
        String to = input.nextLine();
        System.out.print("Subject: ");
        String subject = input.nextLine();
        System.out.println("Body: ");
        String body = input.nextLine();
        Email newEmail = new Email(count, user.getEmail(), to, subject, body, LocalDateTime.now(), false);
        count = sendEmail(count, newEmail);
        return count;
    }

    private static int sendEmail(int count, Email email) {
        String SQL = "INSERT INTO public.email " + "VALUES (?,?,?,?,?,?,?)";
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
            return ++count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createAppt() {

    }
}
