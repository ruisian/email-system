package com.email.App;

import com.email.Users.User;

import java.util.Scanner;

public class Login {
    // login logout are actions and should have base class/relationship between classes
    // shared login between classes
    // both use println
    // base action class with show/print message
    // extend base action class
    public static void main(String[] args) {

    }

    public static Boolean login(User currentUser) {
        Scanner in = new Scanner(System.in);
        Boolean loggedIn = false;
        System.out.println("Welcome!");
        System.out.println("Enter your username and password");
        System.out.print("username: ");
        enterUser(currentUser, in);
        System.out.print("password: ");
        if(enterPasswd(currentUser, in)){
            System.out.println("User Logging in");
            loggedIn = true;
        }
        return loggedIn;
    }
    private static void enterUser(User currentUser, Scanner in) {
        String user = in.nextLine();
        while (true) {
            if(!user.equals(currentUser.getUsername())){
                System.out.println("No such user, please try again.");
                System.out.print("username: ");
                user = in.nextLine();
            } else {
                break;
            }
        }
        return;
    }

    private static Boolean enterPasswd(User currentUser, Scanner in) {
        String passwd = in.nextLine();
        while (true) {
            if(!passwd.equals(currentUser.getPassword())){
                System.out.println("Wrong password, please try again.");
                System.out.print("password: ");
                passwd = in.nextLine();
            } else {
                break;
            }
        }
        return true;
    }

}
