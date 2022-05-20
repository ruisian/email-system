package com.email.Users;

import com.email.App.page;

public class AdminMenu {
    public static page Display() {
        System.out.println("Administrator options:");
        System.out.println("1. Create New User");
        System.out.println("2. Delete Existing User");
        return chosenPage();
    }
    private static page chosenPage() {
        return null;
    }
}
