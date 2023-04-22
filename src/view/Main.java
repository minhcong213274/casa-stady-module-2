package view;

import controller.ManageSignIn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManageSignIn manageSignIn = ManageSignIn.getManageSignIn();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("---- Member Management System ----");
            System.out.println("Please choose an option:");
            System.out.println("1. Login.");
            System.out.println("2. Sign up.");
            System.out.println("3. Forget password.");
            System.out.println("4. Support to unlock account: ");
            System.out.println("5. Exit");
            System.out.println("-----------------------------------");
            System.out.print("Option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    manageSignIn.login();
                    break;
                case "2":
                    manageSignIn.signUp();
                    System.out.println("Sign Up Success.");
                    break;
                case "3":
                   manageSignIn.forgetPassword();
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
