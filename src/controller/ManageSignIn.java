package controller;

import model.Account;
import view.StudentManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageSignIn {
    private List<Account> signInList;
    Scanner scanner = new Scanner(System.in);

    public ManageSignIn() {
        signInList = new ArrayList<>();
        signInList.add(new Account("Amin","Amin"));
    }

    public void signUp() {
        Account signUp = new Account();
        boolean isValidUsername = false;
        while (!isValidUsername) {
            System.out.println("Enter user name:");
            signUp.setId(scanner.nextLine());
            for (Account account : signInList) {
                if (signUp.getId().equals(account.getId())) {
                    System.out.println("vui long nhap lai:");
                    isValidUsername = false;
                    break;
                }else {
                    isValidUsername = true;
                }
            }
        }
        System.out.println("Enter password");
        signUp.setPassword(scanner.nextLine());
        signInList.add(signUp);
    }
    public void login() {
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();
        for (Account account : signInList) {
            if (account.getId().equals(username) && account.getPassword().equals(password)){
                boolean running = true;
                while (running) {
                    System.out.println("---- Member Management System ----");
                    System.out.println("Please choose an option:");
                    System.out.println("1. Display information.");
                    System.out.println("2. Sign up course.");
                    System.out.println("3. Check point.");
                    System.out.println("4.Kick member. ");
                    System.out.println("-----------------------------------");
                    System.out.print("Option: ");

                    String choice = scanner.nextLine();

                    switch (choice) {
                        case "1":
                            break;
                        case "2":
                            break;
                        case "3":
                            break;
                        case "4":
                            return;
                        default:
                            System.out.println("Invalid option. Please try again.");
                            break;
                    }

                    System.out.println();
                }
            }
        }
        System.out.println("This account is Invalid. ");
        return;
        }
        public void displayInformation(){

        }
}
