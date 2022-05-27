package com.email.app;

import com.email.Users.User;

import java.util.Scanner;

public class MainMenu {
    public static Page display(User user, Boolean isAdmin){
        System.out.println("Please pick category:");
        System.out.println("1. Email");
        System.out.println("2. Appointments");
        System.out.println("3. Log Out");
        if (isAdmin) {
            System.out.println("4. Administrator");
        }
        Page chosenPage = choosePage(user, isAdmin);
        return chosenPage;
    }
    private static Page choosePage(User user, Boolean isAdmin){
        Scanner in = new Scanner(System.in);
        String input = in.next();
        Page chosenPage = null;
        if(input.equals("quit")) {
            return Page.LogOutPage;
        }
        switch (input) {
            case "1":
//                System.out.println("Email");
                chosenPage = Page.EmailMenuPage;
                break;
            case "2":
//                System.out.println("appt");
                chosenPage = Page.AppointmentsMenuPage;
                break;
            case "3":
//                System.out.println("logout");
                chosenPage = Page.LogOutPage;
                break;
            case "4":
                if (isAdmin) {
//                    System.out.println("admin");
                    chosenPage = Page.AdminMenuPage;
                } else {
                    chosenPage = Page.MainMenuPage;
                }
                break;
            default:
                System.out.println("Invalid option, please try again.");
                chosenPage = Page.MainMenuPage;
                break;
        }
        return chosenPage;
    }
}
