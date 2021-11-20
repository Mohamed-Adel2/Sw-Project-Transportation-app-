package com.company;

import java.util.Scanner;

public class Login {
    public boolean ChkUser(String name,String pass){
        System.out.println("Login As: 1-User"+"/n"+"2-Driver");
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        Data d=Data.getInstance();
        while(choice!=1 || choice!=2){
            System.out.println("Wrong Choice Please Enter 1 or 2!");
            choice=sc.nextInt();
        }
        if (choice==1) {
            for (int i = 0; i < d.getUsers().size(); i++) {
                if (d.getUsers().get(i).getUserName() == name  && d.getUsers().get(i).getPassword() == pass) {
                    return true;
                }
            }
        }
        else if(choice==2){
            for (int i = 0; i < d.getDrivers().size(); i++) {
                if (d.getDrivers().get(i).getUserName() == name  && d.getDrivers().get(i).getPassword() == pass) {
                    return true;
                }
            }
        }
        System.out.println("Wrong UserName or Password");
        return false;
    }
}
