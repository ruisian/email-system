package com.email.app;

import com.email.EmailAppt.EmailMenu;
import com.email.Users.Role;
import com.email.Users.User;
import com.email.app.actions.ActionInterface;
import com.email.app.actions.LogOutAction;
import com.email.app.actions.LoginAction;

import java.sql.SQLException;
import java.util.Scanner;

public class runApp {
    public static boolean main(Page currentPage) throws Exception{
        Boolean isAdmin = false;

        User currentUser = null;
        // Page currentPage = Page.UserLoginPage;
        Page prevPage = currentPage;
        Boolean isLogout = false;

        Scanner s = new Scanner(System.in);
        Boolean toQuit = false;
        while (true) {
            try {
                toQuit = isLogout(currentPage, prevPage, currentUser);
                if (toQuit) {
                    return true;
                }
                currentPage = pageChoice(currentUser, currentPage, prevPage, s, isAdmin, toQuit);

//                if (currentPage == null) {
//                    return toQuit;
//                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private static Page pageChoice(User currentUser, Page currentPage, Page prevPage, Scanner s, Boolean isAdmin, Boolean toQuit) throws Exception {
        switch (currentPage){
            case UserLoginPage:
                ActionInterface login = new LoginAction();
                currentUser = (User)login.executeAction();
                if (currentUser != null) {
                    isAdmin = false;
                    if (currentUser.getRole().equals(Role.Admin)){
                        isAdmin = true;
                    }
                    System.out.println("Logged in as " + currentUser.getLastname() + currentUser.getFirstname());
                    // prevPage = currentPage;
                    currentPage = Page.MainMenuPage;
                }
                break;
            case MainMenuPage:
                // prevPage = currentPage;
                currentPage = MainMenu.display(currentUser, isAdmin);
                break;
            case EmailMenuPage:
                // prevPage = currentPage;
                currentPage = EmailMenu.display(currentUser);
                break;
            case AppointmentsMenuPage:
                System.out.println("AppointmentsMenu");
                break;
            case LogOutPage:
                ActionInterface logout = new LogOutAction();
                logout.executeAction(currentUser);
                currentPage = Page.UserLoginPage;
                break;
            case AdminMenuPage:
                System.out.println("AdminMenu");
                break;
            default:
                currentPage = Page.MainMenuPage;
                break;
        }
        return currentPage;
    }

    private static Boolean isLogout(Page currentPage, Page prevPage, User currentUser) throws Exception{
        if (currentPage == Page.LogOutPage) {
            ActionInterface logout = new LogOutAction();
            logout.executeAction(currentUser);
        }
        return false;
    }
}
