package com.email.App;

import com.email.EmailAppt.EmailMenu;
import com.email.Users.User;
import com.email.Users.role;
import com.sun.tools.javac.Main;

import java.time.LocalDate;
import java.util.Scanner;

import static com.email.App.page.UserLoginPage;

public class App {

    // static volatile boolean keepRunning = true;
    static User currentUser;
    static page currentPage;

//    public synchronized void run() {
//        System.out.println("Welcome!");
//        Scanner s = new Scanner(System.in);
//        while(keepRunning == true){
//            if(s.next().equals("quit")){ s.
//                keepRunning = false;
//                break;
//            }
//            System.out.println("Running loop...");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//            }
//        }
//        System.out.println("Goodbye!");
//    }

    public static void main(String[] args) {
        DBConnection.connect();

        User admin1 = new User(1, "ming", "xiao", LocalDate.of(2000,1,1), "xiaoming@company.com", "xiaoming", "xiaoming123", role.Admin);
        User user1 = new User(2, "hua", "xiao", LocalDate.of(2000,1,2), "xiaohua@company.com", "xiaohua", "xiaohua123", role.User);
        currentUser = admin1;

        Boolean isAdmin = false;
        if (currentUser.getRole().equals(role.Admin)){
            isAdmin = true;
        }

        currentPage = page.UserLoginPage;
        page prevPage = currentPage;

        Scanner s = new Scanner(System.in);
        Boolean toQuit = false;

        while (true) {
            switch (currentPage){
                case UserLoginPage:
                    if (Login.login(currentUser)) {
                        System.out.println("Logged in as " + currentUser.getLastname() + currentUser.getFirstname());
                        prevPage = currentPage;
                        currentPage = page.MainMenuPage;
                    }
                    break;
                case MainMenuPage:
                    prevPage = currentPage;
                    currentPage = MainMenu.Display(currentUser, isAdmin);
                    break;
                case EmailMenuPage:
                    //System.out.println("Email menu");
                    prevPage = currentPage;
                    currentPage = EmailMenu.Display();
                    break;
                case AppointmentsMenuPage:
                    System.out.println("AppointmentsMenu");
                    break;
                case LogOutPage:
                    LogOut.Display(currentUser);
                    if(s.next().charAt(0) == 'y') {
                        toQuit = true;
                    } else {
                        currentPage = prevPage;
                    }
                    break;
                case AdminMenuPage:
                    System.out.println("AdminMenu");
                    break;
                default:
                    currentPage = page.MainMenuPage;
                    break;
            }

            if(toQuit) {
                break;
            }
//            if(s.next().equals("quit")){
//                break;
//            }
        }




    }

}
