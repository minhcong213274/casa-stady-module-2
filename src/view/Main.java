package view;

import controller.ManageSignIn;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManageSignIn manageSignIn = ManageSignIn.getManageSignIn();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("---- Member Management System ----");
            for (String s : Arrays.asList("Please choose an option:", "1. Login.", "2. Sign up.", "3. Forget password.", "4. Support to unlock account: ", "5. Exit", "-----------------------------------")) {
                System.out.println(s);
            }

            System.out.print("Option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> manageSignIn.login();
                case "2" -> {
                    manageSignIn.signUp();
                    System.out.println("Sign Up Success.");
                }
                case "3" -> manageSignIn.forgetPassword();
                case "4" -> manageSignIn.supportAccount();
                case "5" -> {
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }

            System.out.println();
        }
    }
}
