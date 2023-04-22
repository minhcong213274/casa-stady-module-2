package controller;

import model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageSignIn {
    private List<Account> signInList;
    Scanner scanner = new Scanner(System.in);

    public List<Account> getSignInList() {
        return signInList;
    }

    public void setSignInList(List<Account> signInList) {
        this.signInList = signInList;
    }

    public ManageSignIn() {
        signInList = new ArrayList<>();
        signInList.add(new Account("Amin","Amin"));
    }
    private static ManageSignIn manageSignIn = null;
    public static ManageSignIn getManageSignIn(){
        if (manageSignIn == null) manageSignIn = new ManageSignIn();
        return manageSignIn;
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
        int index;
        for (Account account : signInList) {
            if (account.getId().equals(username) && account.getPassword().equals(password)){
                if(account.getName()==null){
                    System.out.println("Enter your name:");
                    account.setName(scanner.nextLine());
                    System.out.println("Enter your address:");
                    account.setAddress(scanner.nextLine());
                    System.out.println("Enter your age:");
                    account.setAge(scanner.nextInt());
                }
                index = signInList.indexOf(account);
                boolean running = true;
                while (running) {
                    System.out.println("---- Member Management System ----");
                    System.out.println("Please choose an option:");
                    System.out.println("1. Display information.");
                    System.out.println("2. Sign up course.");
                    System.out.println("3. Change password.");
                    System.out.println("4.Delete account member. ");
                    System.out.println("-----------------------------------");
                    System.out.print("Option: ");

                    String choice = scanner.nextLine();

                    switch (choice) {
                        case "1":
                            displayInformation();
                            break;
                        case "2":
                            signUpCourse(index);
                            break;
                        case "3":
                            changePassword(index);
                            break;
                        case "4":
                            deleteAccountMember(index);
                            break;
                        case "5":
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
        public void deleteAccountMember(int index){
        if (signInList.get(index).getAccessLevel().equals("Mod")){
            System.out.println("Enter id you want delete:");
            String id = scanner.nextLine();
            for (Account account : signInList) {
                if (account.getId().equals(id) && account.getAccessLevel().equals("Member")){
                    signInList.remove(account);
                    return;
                }
            }
            System.out.println("Id not found:");
        }
        }
        public void displayInformation(){
            for (Account account : signInList) {
                if (account.getAccessLevel().equals("Member")){
                    System.out.println(account.getId()+account.getName()+account.getAge()+account.getAddress()+account.getTuition());
                }
            }
        }
        public void changePassword(int index){
            System.out.println("Enter new password ");
        signInList.get(index).setPassword(scanner.nextLine());
        }
    public void signUpCourse(int index){
        boolean running = true;
        while (running) {
            System.out.println("Please choose an option:");
            System.out.println("1. Java cost 300$.");
            System.out.println("2. C++ cost 250$.");
            System.out.println("3. Tester cost 500$.");
            System.out.println("4. Exit");
            System.out.println("-----------------------------------");
            System.out.print("Option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    signUpJava(index);
                    System.out.println("Sign Up Success.");
                    break;
                case "2":
                    signUpC(index);
                    System.out.println("Sign Up Success.");
                    break;
                case "3":
                    signUpTester(index);
                    System.out.println("Sign Up Success.");
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
    public void signUpJava(int index){
        if (!signInList.get(index).isJava()){
            signInList.get(index).setJava(true);
            signInList.get(index).setTuition(300);
        }
          return;
    }
    public void signUpC(int index){
        if (!signInList.get(index).isC()){
            signInList.get(index).setC(true);
            signInList.get(index).setTuition(250);
        }
        return;

    }
    public void signUpTester(int index){
        if (!signInList.get(index).isTester()){
            signInList.get(index).setTester(true);
            signInList.get(index).setTuition(500);
        }return;
    }
}
