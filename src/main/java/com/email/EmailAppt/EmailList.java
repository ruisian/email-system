package com.email.EmailAppt;

import com.email.App.HikariCPDataSource;
import com.email.App.page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmailList {

    public static void ListEmails() {
        getEmails();
        return; //page.ListEmailsPage;
    }

    private static void getEmails() {
        String SQL = "SELECT id,emailfrom,emailto,subject FROM email";
        try (Connection con = HikariCPDataSource.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(SQL);
            displayEmails(res);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void displayEmails(ResultSet res) throws SQLException {
        while (res.next()) {
            System.out.println(res.getString("id") + "\t"
                    + res.getString("emailfrom") + "\t"
                    + res.getString("emailto") + "\t"
                    + res.getString("subject"));

        }
    }

}
