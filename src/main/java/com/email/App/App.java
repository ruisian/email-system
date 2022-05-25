package com.email.App;

import com.email.EmailAppt.EmailMenu;
import com.email.Users.User;
import com.email.Users.Role;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class App {

    // static volatile boolean keepRunning = true;
    static User currentUser = null;
    static Page currentPage;

    public static void main(String[] args) throws SQLException {
         // DBConnection.connect();

        /*
        TODO
        should rewrite code to use REST API
        move to spring boot
        pom.xml
        separate actions in class
        */

        Boolean isAdmin = false;


        currentPage = Page.UserLoginPage;
        Page prevPage = currentPage;

        Scanner s = new Scanner(System.in);
        Boolean toQuit = false;

        while (true) {
            // TODO
            // run() //new menu start
            switch (currentPage){
                case UserLoginPage:
                    currentUser = Login.login();
                    if (currentUser != null) {
                        isAdmin = false;
                        if (currentUser.getRole().equals(Role.Admin)){
                            isAdmin = true;
                        }
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
                    } else if(s.next().charAt(0) == 'l') {
                        System.out.println("User logging out.");
                        currentPage = Page.UserLoginPage;
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
