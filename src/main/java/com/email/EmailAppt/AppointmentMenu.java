package com.email.EmailAppt;

import com.email.App.page;

import java.util.Scanner;

public class AppointmentMenu {
    public static page Display() {
        System.out.println("Appointment options:");
        System.out.println("1. Create Appointment");
        System.out.println("2. Get Appointment by Date");
        return choosePage();
    }

    private static page choosePage() {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        page chosenPage = null;
        if(input.equals("quit")) {
            return page.LogOutPage;
        }
        switch (input) {
            case "1":
                System.out.println("CreateAppointmentPage");
                chosenPage = page.CreateAppointmentPage;
                break;
            case "2":
                System.out.println("GetAppointmentPage");
                chosenPage = page.GetAppointmentPage;
                break;
            default:
                System.out.println("Invalid option, please try again.");
                chosenPage = page.AppointmentsMenuPage;
                break;
        }
        return chosenPage;
    }
}
