package com.email.App;

import com.email.Users.User;
import com.email.Users.role;

import java.util.Scanner;

public class MainMenu {
    public static page Display(User user, Boolean isAdmin){
        System.out.println("Please pick category:");
        System.out.println("1. Email");
        System.out.println("2. Appointments");
        System.out.println("3. Log Out");
        if (isAdmin) {
            System.out.println("4. Administrator");
        }
        page chosenPage = choosePage(user, isAdmin);
        return chosenPage;
    }
    private static page choosePage(User user, Boolean isAdmin){
        Scanner in = new Scanner(System.in);
        String input = in.next();
        page chosenPage = null;
        if(input.equals("quit")) {
            return page.LogOutPage;
        }
        switch (input) {
            case "1":
//                System.out.println("Email");
                chosenPage = page.EmailMenuPage;
                break;
            case "2":
//                System.out.println("appt");
                chosenPage = page.AppointmentsMenuPage;
                break;
            case "3":
//                System.out.println("logout");
                chosenPage = page.LogOutPage;
                break;
            case "4":
                if (isAdmin) {
//                    System.out.println("admin");
                    chosenPage = page.AdminMenuPage;
                } else {
                    chosenPage = page.MainMenuPage;
                }
                break;
            default:
                System.out.println("Invalid option, please try again.");
                chosenPage = page.MainMenuPage;
                break;
        }
        return chosenPage;
    }
}
