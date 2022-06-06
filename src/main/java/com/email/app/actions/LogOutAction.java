package com.email.app.actions;

import java.util.Scanner;

public class LogOutAction extends AuditableAction{
    public LogOutAction() {
        super("Logout Action");
    }


    @Override
    public Object executeAuditableAction() {
        return null;
    }

    @Override
    public Object executeAuditableAction(Object o) {
        System.out.println("Logout? y/n");
        Scanner s = new Scanner(System.in);
        char nextChar = s.next().charAt(0);
        if(nextChar == 'y') {
            System.out.println("User logging out.");
        } else if(nextChar == 'q') {
            System.exit(1);
        }
        return null;
    }
}
