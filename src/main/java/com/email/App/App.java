package com.email.App;

import com.email.EmailAppt.EmailMenu;
import com.email.Users.User;
import com.email.Users.Role;

import java.time.LocalDate;
import java.util.Scanner;

public class App {

    // static volatile boolean keepRunning = true;
    static User currentUser;
    static Page currentPage;

    public static void main(String[] args) {
         // DBConnection.connect();

        /*
        TODO
        should rewrite code to use REST API
        move to spring boot
        pom.xml
        seperate actions in class
        */

        User admin1 = new User(1, "ming", "xiao", LocalDate.of(2000,1,1), "xiaoming@company.com", "xiaoming", "xiaoming123", Role.Admin);
        User user1 = new User(2, "hua", "xiao", LocalDate.of(2000,1,2), "xiaohua@company.com", "xiaohua", "xiaohua123", Role.User);
        currentUser = admin1;

        Boolean isAdmin = false;
        if (currentUser.getRole().equals(Role.Admin)){
            isAdmin = true;
        }

        currentPage = Page.UserLoginPage;
        Page prevPage = currentPage;

        Scanner s = new Scanner(System.in);
        Boolean toQuit = false;

        while (true) {
            //run() /new menu start
            switch (currentPage){
                case UserLoginPage:
                    if (Login.login(currentUser)) {
                        System.out.println("Logged in as " + currentUser.getLastname() + currentUser.getFirstname());
                        prevPage = currentPage;
                        currentPage = Page.MainMenuPage;
                    }
                    break;
                case MainMenuPage:
                    prevPage = currentPage;
                    currentPage = MainMenu.display(currentUser, isAdmin);
                    break;
                case EmailMenuPage:
                    //System.out.println("Email menu");
                    prevPage = currentPage;
                    currentPage = EmailMenu.display(currentUser);
                    break;
                case AppointmentsMenuPage:
                    System.out.println("AppointmentsMenu");
                    break;
                case LogOutPage:
                    LogOut.display(currentUser);
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
                    currentPage = Page.MainMenuPage;
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
