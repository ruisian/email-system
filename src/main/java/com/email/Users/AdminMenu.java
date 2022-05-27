package com.email.Users;

import com.email.app.Page;

public class AdminMenu {
    public static Page display() {
        System.out.println("Administrator options:");
        System.out.println("1. Create New User");
        System.out.println("2. Delete Existing User");
        return chosenPage();
    }
    private static Page chosenPage() {
        return null;
    }
}
