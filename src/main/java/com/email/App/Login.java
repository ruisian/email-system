package com.email.App;

import com.email.Users.Role;
import com.email.Users.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Login {
    // login logout are actions and should have base class/relationship between classes
    // shared login between classes
    // both use println
    // base action class with show/print message
    // extend base action class
    public static void main(String[] args) {

    }

    public static User login() throws SQLException {
        Scanner in = new Scanner(System.in);
        Boolean loggedIn = false;
        User currentUser = null;
        System.out.println("Welcome!");
        while(!loggedIn) {
            currentUser = enterDetails(in, currentUser);
            if(currentUser != null) {
                loggedIn = true;
            } else {
                System.out.println("Incorrect username or password, please try again.");
            }
        }
        return currentUser;
    }
    private static User enterDetails(Scanner in, User currentUser) throws SQLException {
        System.out.println("Enter your username and password");
        System.out.print("username: ");
        String user = in.nextLine();
        System.out.print("password: ");
        String passwd = in.nextLine();
        currentUser = sendQuery(user, passwd);
        return currentUser;
    }

    private static User sendQuery(String username, String password) {
        String SQL = "SELECT * FROM public.user WHERE " + "username = ? AND password = ?"; //id, firstname, lastname, dob, email, username, password, role_id
        ResultSet res;
        User currentUser = null;
        try (Connection con = HikariCPDataSource.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(SQL);
            stmt.setString(1, username);
            stmt.setString(2, password);
            res = stmt.executeQuery();
            while (res.next()) {
                int id = res.getInt("id");
                String firstname = res.getString("firstname");
                String lastname = res.getString("lastname");
                LocalDate dob = Date.valueOf(res.getString("dob")).toLocalDate();
                String email = res.getString("email");
                // String username = res.getString("username");
                // String password = res.getString("password");
                int role_id = res.getInt("role_id");
                Role role = Role.valueOf(getRole(role_id));
                currentUser = new User(id, firstname, lastname, dob, email, username, password, role);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return currentUser;
    }

    private static String getRole(int id) {
        String SQL = "SELECT name FROM public.role WHERE " + "id = ?";
        String role = null;
        try (Connection con = HikariCPDataSource.getConnection()) {
            PreparedStatement stmt2 = con.prepareStatement(SQL);
            stmt2.setInt(1, id);
            ResultSet res2 = stmt2.executeQuery();
            while (res2.next()) {
                role = res2.getString("name");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return role;
    }

}
