package com.email.EmailAppt;

import com.email.App.page;
import com.email.Users.User;

import java.util.Scanner;

public class EmailMenu {
    public static page Display(User user) {
        System.out.println("Email options:");
        System.out.println("1. List Emails");
        System.out.println("2. Send Email");
        System.out.println("3. Find Email by Subject");
        System.out.println("4. Email Archive");

        page chosenPage = choosePage(user);
        return chosenPage;
    }
    private static page choosePage(User user) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        page chosenPage = null;
        if(input.equals("quit")) {
            return page.LogOutPage;
        }
        switch (input) {
            case "1":
                System.out.println("List of Emails");
                System.out.println("Enter a to choose emails to send to archive");
                System.out.println("Enter q to return to previous menu");
                // chosenPage = page.ListEmailsPage;
                EmailList.ListEmails();
                if(in.next().equals("q")){
                    chosenPage = page.EmailMenuPage;
                }
                break;
            case "2":
                System.out.println("Send New Email");
                chosenPage = page.SendEmailPage;
                emailAppt type = emailAppt.Email;
                SendEmailEntity.CreateNew(type, user);
                chosenPage = page.EmailMenuPage;
                break;
            case "3":
                System.out.println("Find Email by Subject");
                chosenPage = page.FindEmailPage;
                break;
            case "4":
                System.out.println("Email Archive");
                chosenPage = page.EmailArchivePage;
                break;
            default:
                System.out.println("Invalid option, please try again.");
                chosenPage = page.EmailMenuPage;
                break;
        }
        return chosenPage;
    }
}
