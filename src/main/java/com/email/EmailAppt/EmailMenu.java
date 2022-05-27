package com.email.EmailAppt;

import com.email.app.Page;
import com.email.Users.User;

import java.util.Scanner;

public class EmailMenu {
    public static Page display(User user) {
        System.out.println("Email options:");
        System.out.println("1. List Emails");
        System.out.println("2. Send Email");
        System.out.println("3. Find Email by Subject");
        System.out.println("4. Email Archive");

        Page chosenPage = choosePage(user);
        return chosenPage;
    }
    private static Page choosePage(User user) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        Page chosenPage = null;
        if(input.equals("quit")) {
            return Page.LogOutPage;
        }
        switch (input) {
            /*
             TODO
             line 36-40 should be moved to another class called email list action to call from here instead of hard coding here
             should share same code from cmd or web // spring boot
            */
            case "1":
                System.out.println("List of Emails");
                System.out.println("Enter a to choose emails to send to archive");
                System.out.println("Enter q to return to previous menu");
                // chosenPage = page.ListEmailsPage;
                EmailList.listEmails();
                if(in.next().equals("q")){
                    chosenPage = Page.EmailMenuPage;
                }
                break;
            case "2":
                System.out.println("Send New Email");
                chosenPage = Page.SendEmailPage;
                EmailAppt type = EmailAppt.Email;
                SendEmailEntity.createNew(type, user);
                chosenPage = Page.EmailMenuPage;
                break;
            case "3":
                System.out.println("Find Email by Subject");
                chosenPage = Page.FindEmailPage;
                break;
            case "4":
                System.out.println("Email Archive");
                chosenPage = Page.EmailArchivePage;
                break;
            default:
                System.out.println("Invalid option, please try again.");
                chosenPage = Page.EmailMenuPage;
                break;
        }
        return chosenPage;
    }
}
