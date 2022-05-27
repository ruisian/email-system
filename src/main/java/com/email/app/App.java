package com.email.app;

import com.email.Users.User;

import java.sql.SQLException;
import java.util.Scanner;

public class App {

    // static volatile boolean keepRunning = true;
    static User currentUser = null;
    static Page currentPage = Page.UserLoginPage;

    Boolean isAdmin = false;
    // currentPage = Page.UserLoginPage;
    Page prevPage = currentPage;
    Scanner s = new Scanner(System.in);
    static Boolean toQuit = false;

    public static void main(String[] args) throws Exception {
         // DBConnection.connect();

        /*
        TODO
        should rewrite code to use REST API
        move to spring boot
        pom.xml
        separate actions in class
        */





        while (true) {
            // TODO
            // run() //new menu start
            toQuit = runApp.main(currentPage);
//            switch (currentPage){
//                case UserLoginPage:
//                    currentUser = Login.login();
//                    if (currentUser != null) {
//                        isAdmin = false;
//                        if (currentUser.getRole().equals(Role.Admin)){
//                            isAdmin = true;
//                        }
//                        System.out.println("Logged in as " + currentUser.getLastname() + currentUser.getFirstname());
//                        prevPage = currentPage;
//                        currentPage = Page.MainMenuPage;
//                    }
//                    break;
//                case MainMenuPage:
//                    prevPage = currentPage;
//                    currentPage = MainMenu.display(currentUser, isAdmin);
//                    break;
//                case EmailMenuPage:
//                    prevPage = currentPage;
//                    currentPage = EmailMenu.display(currentUser);
//                    break;
//                case AppointmentsMenuPage:
//                    System.out.println("AppointmentsMenu");
//                    break;
//                case LogOutPage:
//                    LogOut.display(currentUser);
//                    char nextChar = s.next().charAt(0);
//                    if(nextChar == 'y') {
//                        System.out.println("User logging out.");
//                        currentPage = Page.UserLoginPage;
//                    } else if(nextChar == 'q') {
//                        toQuit = true;
//                    } else {
//                        currentPage = prevPage;
//                    }
//                    break;
//                case AdminMenuPage:
//                    System.out.println("AdminMenu");
//                    break;
//                default:
//                    currentPage = Page.MainMenuPage;
//                    break;
//            }

            if(toQuit) {
                break;
            }
//            if(s.next().equals("quit")){
//                break;
//            }
        }




    }

}
