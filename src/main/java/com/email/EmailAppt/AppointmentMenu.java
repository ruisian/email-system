package com.email.EmailAppt;

import com.email.app.Page;

import java.util.Scanner;

public class AppointmentMenu {
    public static Page display() {
        System.out.println("Appointment options:");
        System.out.println("1. Create Appointment");
        System.out.println("2. Get Appointment by Date");
        return choosePage();
    }

    private static Page choosePage() {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        Page chosenPage = null;
        if(input.equals("quit")) {
            return Page.LogOutPage;
        }
        switch (input) {
            case "1":
                System.out.println("CreateAppointmentPage");
                chosenPage = Page.CreateAppointmentPage;
                break;
            case "2":
                System.out.println("GetAppointmentPage");
                chosenPage = Page.GetAppointmentPage;
                break;
            default:
                System.out.println("Invalid option, please try again.");
                chosenPage = Page.AppointmentsMenuPage;
                break;
        }
        return chosenPage;
    }
}
